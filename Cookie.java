public class Cookie {

	private String cookie_id;
	private String cookie_time;
	
	public Cookie(String id, String time) {
		cookie_id = id;
		cookie_time = time;
	}
	
	public String getID() {
		return cookie_id;
	}
	
	public String getTime() {
		return cookie_time;
	}
	
	public String toString() {
		return cookie_id; 
	}
	
}
