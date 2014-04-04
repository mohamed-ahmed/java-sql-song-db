package java_sqlite_3005;

public class Place {
	/*
	 * This class represents a song that appears in a fake book database
	 */
	
	private int  placeID; //database table primary key id
	private String name;
	private String type; 
	private String location;
	private String address;
	private String website;
	private int opening_hours;
	private int closing_hours;
	private int rating;
	
	
	public Place(int placeID, String name, String type, String location, String address, String website, int opening_hours, int closing_hours, int rating){
		this.placeID = placeID;
		this.name = name;
		this.type = type;
		this.location = location;
		this.address = address;
		this.website = website;
		this.opening_hours = opening_hours;
		this.closing_hours = closing_hours;
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}



	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}



	/**
	 * @return the opening_hours
	 */
	public int getOpening_hours() {
		return opening_hours;
	}



	/**
	 * @param opening_hours the opening_hours to set
	 */
	public void setOpening_hours(int opening_hours) {
		this.opening_hours = opening_hours;
	}



	/**
	 * @return the closing_hours
	 */
	public int getClosing_hours() {
		return closing_hours;
	}



	/**
	 * @param closing_hours the closing_hours to set
	 */
	public void setClosing_hours(int closing_hours) {
		this.closing_hours = closing_hours;
	}



	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}



	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}



	public String toString(){
		
		String s = "";
		s += placeID;
		s += name;
		s += type;
		s += location;
		s += address;
		s += website;
		s += opening_hours;
		s += closing_hours;
		
		return s;
	}



}
