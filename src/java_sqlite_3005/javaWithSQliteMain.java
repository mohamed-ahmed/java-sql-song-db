package java_sqlite_3005;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class javaWithSQliteMain {

    
	public static void main(String[] args) {
		System.out.println("Java With SQLite example");
		GUI frame = null;
		

		//Connect to database
        try {
        	
        	//direct java to the sqlite-jdbc driver jar code
        	// load the sqlite-JDBC driver using the current class loader
			Class.forName("org.sqlite.JDBC");
			
			//create connection to a database in the project home directory.
			//if the database does not exist one will be created in the home directory
		    
			//Connection conn = DriverManager.getConnection("jdbc:sqlite:mytest.db");
			Connection database = DriverManager.getConnection("jdbc:sqlite:placesDB");
		       //create a statement object which will be used to relay a
		       //sql query to the database
		     Statement stat = database.createStatement();

		    /*
		     * SQLite supports in-memory databases, which does not create any database files
		     * To use in memory database in your Java code, get the database connection as follows:
		     *
		     * Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
		     * 
		    */
			
		   
                //Query database for initial contents for GUI

	            String sqlQueryString = "select * from service order by name asc;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Service> services = new ArrayList<Service>();

		        ResultSet rs = stat.executeQuery(sqlQueryString);
		        while (rs.next()) {
		            //System.out.print("code: " + rs.getString("code"));
		            //System.out.println(" title = " + rs.getString("title"));
		            Service	service = new Service(rs.getInt("service_id"), rs.getString("name"), rs.getString("type"), rs.getString("website"));
		            services.add(service);
		        }
		        rs.close(); //close the query result table
		        


	            sqlQueryString = "select * from place;";
		        rs = stat.executeQuery(sqlQueryString);
	            System.out.println("");
	            System.out.println(sqlQueryString);
	            
	            ArrayList<Place> placeSearchResults = new ArrayList<Place>();

		        int DISPLAY_LIMIT = 100;
		        int count = 0;
		        while (rs.next() && count < DISPLAY_LIMIT){
		            //System.out.print("id: " + rs.getString("id"));
		            //System.out.print("book: " + rs.getString("bookcode"));
		            //System.out.print(" page: " + rs.getInt("page"));
		            //System.out.println(" song: " + rs.getString("title"));
		            
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
		        
		        Place[] placeArray = new Place[1]; //just to establish array type
		        placeArray =  placeSearchResults.toArray(placeArray);
				
		        //Create GUI with knowledge of database and initial query content
		        frame =  new GUI("Place Database", database, stat, services, placeSearchResults); //create GUI frame with knowledge of the database
		        
		        //Leave it to GUI to close database
		        //conn.close(); //close connection to database			
												
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        //make GUI visible
		frame.setVisible(true);




	}

}
