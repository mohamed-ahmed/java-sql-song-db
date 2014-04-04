package java_sqlite_3005;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PlaceDetailsDialog extends JDialog {

	// This is a pointer to the email buddy that is being edited
	private Place thePlace;
	
	DialogClient theDialogClient;

	// These are the components of the dialog box
	private JLabel					aLabel; //reuseable label variable
	
	private JTextField				nameField; //name of the song
	private JTextField				typeField; //artist of the song
	private JTextField				typeield; //price of the song
	private JTextField				website; //year of the song
	
	private JButton					updateButton;
	private JButton					deleteButton;
	private JButton					cancelButton;
	
	Font UIFont = new Font("Courier New", Font.BOLD, 16);
	


	public PlaceDetailsDialog(Frame owner, DialogClient aClient, String title, boolean modal, Place placeBeingEdited){
		super(owner,title,modal);

		//Store the client and model variables
		theDialogClient = aClient;
		thePlace = placeBeingEdited;

		// Put all the components onto the window and given them initial values
		buildDialogWindow(thePlace);

		// Add listeners for the Ok and Cancel buttons as well as window closing
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				updateButtonClicked();
			}});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				deleteButtonClicked();
			}});


		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				cancelButtonClicked();
			}});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				cancelButtonClicked();
			}});

		setSize(400, 250);
		
	}

	// This code adds the necessary components to the interface
	private void buildDialogWindow(Place thePlace) {
		
   		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints lc = new GridBagConstraints();
        getContentPane().setLayout(layout);

 
        lc.anchor = GridBagConstraints.EAST;
        lc.insets = new Insets(5, 5, 5, 5);

        aLabel = new JLabel("Title");
        lc.gridx = 0; lc.gridy = 0;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Book");
        lc.gridx = 0; lc.gridy = 1;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Page");
        lc.gridx = 0; lc.gridy = 2;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("key");
        lc.gridx = 0; lc.gridy = 3;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);


        aLabel = new JLabel("  "); //blank label
        lc.gridx = 0; lc.gridy = 5;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("  "); //blank label
        lc.gridx = 1; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
   		
   		// Add the name field
		nameField = new JTextField(thePlace.getName());
		nameField.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 0;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(nameField, lc);
   		getContentPane().add(nameField);

		// Add the address field
		typeField = new JTextField(thePlace.getService());
		typeField.setFont(UIFont);

        lc.gridx = 1; lc.gridy = 1;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(typeField, lc);
   		getContentPane().add(typeField);
        
 
 		// Add the year field
		pageField = new JTextField(""+ thePlace.getPage());
		pageField.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 2;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(pageField, lc);
   		getContentPane().add(pageField);
        

 		// Add the price field
		idField = new JTextField(""+ thePlace.getID());
		idField.setFont(UIFont);
		lc.gridx = 1; lc.gridy = 3;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(idField, lc);
   		getContentPane().add(idField);


		// Add the Update button
		updateButton = new JButton("UPDATE");

        lc.gridx = 1; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(updateButton, lc);
   		getContentPane().add(updateButton);
        
		// Add the Delete button
		deleteButton = new JButton("DELETE");

        lc.gridx = 2; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(deleteButton, lc);
   		getContentPane().add(deleteButton);

   		// Add the Cancel button
		cancelButton = new JButton("CANCEL");
        
        lc.gridx = 3; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(cancelButton, lc);
   		getContentPane().add(cancelButton);
		
		
	}


	private void updateButtonClicked(){
		
		thePlace.setName(nameField.getText());
		thePlace.setType(typeField.getText());
		thePlace.setPage(pageField.getText());
		
		//Inform the dialog client that the dialog finished
		
		if (theDialogClient != null) theDialogClient.dialogFinished(DialogClient.operation.UPDATE);
		
		//Make the dialog go away
		
		dispose();


	}
	
	private void deleteButtonClicked(){
		
		thePlace.setID(idField.getText());
		thePlace.setTitle(titleField.getText());
		thePlace.setBookCode(typeField.getText());
		thePlace.setPage(pageField.getText());
		
		//Inform the dialog client that the dialog finished
		
		if (theDialogClient != null) theDialogClient.dialogFinished(DialogClient.operation.DELETE);
		
		//Make the dialog go away
		
		dispose();


	}

	private void cancelButtonClicked(){
		
		//Inform the dialog client that the dialog finished
		
		if (theDialogClient != null) theDialogClient.dialogCancelled();

		//Make the dialog go away

		dispose();



	}
}