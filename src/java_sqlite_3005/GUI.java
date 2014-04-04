package java_sqlite_3005;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GUI extends JFrame implements DialogClient{

	public int GUI_DISPLAY_LIMIT = 100;

	// Store the model as a vector of email buddies

	Connection databaseConnection;
	Statement stat;

	ArrayList<Service> serviceList = new ArrayList<Service>();
	ArrayList<Place> placeList = new ArrayList<Place>();


	private Place    selectedPlace; //place currently selected in the GUI list
	private Service		selectedService; //service currently selected in the GUI list

	private Place placeBeingEdited; //place being edited in a dialog

	// Store the view that contains the components
	ListPanel 		view; //panel of GUI components for the main window
	GUI thisFrame;

	// Here are the component listeners
	ActionListener			theSearchButtonListener;
	ListSelectionListener	placeListSelectionListener;
	ListSelectionListener	serviceListSelectionListener;
	MouseListener			doubleClickPlaceListListener;
	KeyListener             keyListener;

	// Here is the default constructor
	public GUI(String title, Connection aDB, Statement aStatement, ArrayList<Service> initialServices, ArrayList<Place> initialPlaces) {
		super(title);
		
		databaseConnection = aDB;
		stat = aStatement;

		serviceList = initialServices;
		placeList = initialPlaces;
		selectedService = null;
		selectedPlace = null;
		thisFrame = this;

		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							System.out.println("Closing Database Connection");
							databaseConnection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.exit(0);
					}
				}
				);



		// Make the main window view panel
		add(view = new ListPanel());

		// Add a listener for the add button
		theSearchButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}};



			// Add a listener to allow selection of buddies from the list
			placeListSelectionListener = new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					selectPlace();
				}};
				// Add a listener to allow selection of buddies from the list
				serviceListSelectionListener = new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						selectService();
					}};

					// Add a listener to allow double click selections from the list for editing
					doubleClickPlaceListListener = new MouseAdapter() {
						public void mouseClicked(MouseEvent event) {
							if (event.getClickCount() == 2) {
								JList theList = (JList) event.getSource();
								int index = theList.locationToIndex(event.getPoint());
								placeBeingEdited = (Place) theList.getModel().getElementAt(index);
								System.out.println("Double Click on: " + placeBeingEdited);


								PlaceDetailsDialog dialog = new PlaceDetailsDialog(thisFrame, thisFrame, "Place Details Dialog", true, placeBeingEdited);         
								dialog.setVisible(true);

							} 

						}};

						keyListener = new KeyListener() {

							@Override
							public void keyPressed(KeyEvent arg0) {

							}

							@Override
							public void keyReleased(KeyEvent arg0) {

							}

							@Override
							public void keyTyped(KeyEvent arg0) {

								int keyChar = arg0.getKeyChar();

								if (keyChar == KeyEvent.VK_ENTER)  search();

							}};


							setDefaultCloseOperation(EXIT_ON_CLOSE);
							setSize(600,300);

							// Start off with everything updated properly to reflect the model state
							update();
	}

	// Enable all listeners
	private void enableListeners() {
		view.getSearchButton().addActionListener(theSearchButtonListener);
		view.getServiceList().addListSelectionListener(serviceListSelectionListener);
		view.getPlaceList().addListSelectionListener(placeListSelectionListener);
		view.getPlaceList().addMouseListener(doubleClickPlaceListListener);
		view.getSearchText().addKeyListener(keyListener);
	}

	// Disable all listeners
	private void disableListeners() {
		view.getSearchButton().removeActionListener(theSearchButtonListener);
		view.getServiceList().removeListSelectionListener(serviceListSelectionListener);
		view.getPlaceList().removeListSelectionListener(placeListSelectionListener);
		view.getPlaceList().removeMouseListener(doubleClickPlaceListListener);
		view.getSearchText().removeKeyListener(keyListener);
	}


	// This is called when the user clicks the add button
	private void search() {

		String searchPrototype = view.getSearchText().getText().trim();


		String sqlQueryString = "select * from places where name like '%" + searchPrototype + "%' order by name asc" + ";";
		//check some special cases
		if(searchPrototype.equals("*"))      sqlQueryString = "select * from places" + ";";
		else if(searchPrototype.equals("%")) sqlQueryString = "select * from places" + ";";
		else if(searchPrototype.equals(""))  sqlQueryString = "select * from places" + ";";

		try {
			ResultSet rs = stat.executeQuery(sqlQueryString);

			ArrayList<Place> placeSearchResults = new ArrayList<Place>();

			int count = 0;
			while (rs.next() && count < GUI_DISPLAY_LIMIT){
				Place place = new Place(
						rs.getInt("place_id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getString("location"),
						rs.getString("address"),
						rs.getString("website"),
						rs.getInt("opening_hours"),
						rs.getInt("closing_hours"),
						rs.getInt("rating")
				);

				placeSearchResults.add(place);
				count++;
			}
			rs.close(); //close the query result table
			Place placeArray[] = new Place[1]; //just to establish array type
			placeList = placeSearchResults;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Search clicked");
		update();
	}


	// This is called when the user clicks the edit button


	// This is called when the user selects a service from the list
	private void selectService() {
		selectedService = (Service)(view.getServiceList().getSelectedValue());
		System.out.println("Service Selected: " + selectedService);

		update();
	}
	// This is called when the user selects a place from the list
	private void selectPlace() {
		selectedPlace = (Place)(view.getPlaceList().getSelectedValue());
		System.out.println("Place Selected: " + selectedPlace);

		update();
	}


	// Update the search button
	private void updateSearchButton() {
		view.getSearchButton().setEnabled(true);
	}



	// Update the list
	private void updateList() {
		boolean		foundSelected = false;

		Service serviceArray[] = new Service[1]; //just to establish array type
		view.getServiceList().setListData(((Service []) serviceList.toArray(serviceArray)));

		Place placeArray[] = new Place[1]; //just to establish array type
		view.getPlaceList().setListData(((Place []) placeList.toArray(placeArray)));

		if (selectedService != null)
			view.getServiceList().setSelectedValue(selectedService, true);
		if (selectedPlace != null)
			view.getPlaceList().setSelectedValue(selectedPlace, true);
	}

	// Update the components
	private void update() {
		disableListeners();
		updateList();
		updateSearchButton();
		enableListeners();
	}

	@Override
	public void dialogFinished(DialogClient.operation requestedOperation) {
		// TODO 
		if(requestedOperation == DialogClient.operation.UPDATE){
			//TO DO
			//update place data in database
			System.out.println("UPDATE: " + placeBeingEdited );

			String sqlUpdateString = "update place " 
					+"set "
					//+ "id="  + placeBeingEdited.getID() +", "
					+ "servicecode='" + placeBeingEdited.getServiceCode() + "', "
					+ "page='" + placeBeingEdited.getPage() + "', " 
					+ "title='" + placeBeingEdited.getTitle() + "' "
					+ "where id=" + placeBeingEdited.getID()  + ";";

			System.out.println("sqlUpdateString: " + sqlUpdateString);

			try {
				stat.executeUpdate(sqlUpdateString);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(requestedOperation == DialogClient.operation.DELETE){
			//TODO
			//delete place from database
			int numParams = 0;
			System.out.println("DELETE: " + placeBeingEdited );

			String sqlDeleteString = "delete from place where ";
			if(placeBeingEdited.getID().length() > 0){
				sqlDeleteString	+= " id="  + placeBeingEdited.getID() + " ";
			}

			else{

				if(placeBeingEdited.getServiceCode().length() > 0){
					sqlDeleteString += "servicecode='" + placeBeingEdited.getServiceCode() + "'";
					numParams++;
				}

				if(placeBeingEdited.getPage().length() > 0){
					sqlDeleteString += (numParams > 0 ? " AND " : "");
					sqlDeleteString += " page=" + placeBeingEdited.getPage();
					numParams++;
				}

				if(placeBeingEdited.getTitle().length() > 0){
					sqlDeleteString += (numParams > 0 ? " AND " : "");
					sqlDeleteString += " title='" + placeBeingEdited.getTitle() + "'";
				}
			}

			sqlDeleteString += ";";

			System.out.println("sqlDeleteString: " + sqlDeleteString);

			try {
				stat.executeUpdate(sqlDeleteString);
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
		placeBeingEdited = null;
		
		update();
		search();
	}

	@Override
	public void dialogCancelled() {

		placeBeingEdited = null;
		update();

	}

}