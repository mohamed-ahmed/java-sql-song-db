package java_sqlite_3005;

public class FakeBookSong {
	/*
	 * This class represents a song that appears in a fake book database
	 */
	
	private String id; //database table primary key id
	private String bookcode; //string code for fake book
	private String page; //page number of song in bookcode fakebook
	private String title; //title of song
	
	public FakeBookSong(int databaseKey, String aBookCode, int aPageNumber, String aSongTitle){
		id = "" + databaseKey;
		bookcode = aBookCode;
		page ="" + aPageNumber;
		title = aSongTitle;
	}
	
	public String getID() {
		return id;
	}
	public String getBookCode() {
		return bookcode;
	}
	public String getPage() {
		return page;
	}
	
	public String getTitle() {
		return title;
		}
	
	public void setID(String anID) {
		id = anID;
	}
	
	public void setTitle(String aSongTitle) {
		title = aSongTitle;
	
	}
	public void setBookCode(String aBookCode) {
		bookcode = aBookCode;
	}
	
	public void setPage(String aPage) {
		page = aPage;
	}
	
	public String toString(){
		
		String keyIndent = "";
		int max_key_digits = 6;
		for(int i=0; i< max_key_digits-(""+id).length(); i++ ) keyIndent = keyIndent + " ";
		
		String pageIndent = "";
		int max_page_digits = 5;
		for(int i=0; i< max_page_digits-(""+page).length(); i++ ) pageIndent = pageIndent + " ";
		
		return "" + id + keyIndent + bookcode + "   " + page + pageIndent + title;
	}



}
