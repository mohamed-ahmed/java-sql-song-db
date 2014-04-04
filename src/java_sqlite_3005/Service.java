package java_sqlite_3005;

public class Service {
	/*
	 * This class represents a fake book
	 */
	
	private int serviceID;
	private String name;
	private String type;
	private String website;
	

	public Service(int serviceID , String name, String type, String website){
		this.serviceID = serviceID;
		this.name = name;
		this.type = type;
		this.website = website;
	}
	
	public int getServiceID() {
		return serviceID;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return "" + serviceID + " " +  name + " " + type + " " + website;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getWebsite() {
		return website;
	}
	

	public void setWebsite(String website) {
		this.website = website;
	}


	public void setName(String name){
		this.name = name;
	}
	
	
	

}
