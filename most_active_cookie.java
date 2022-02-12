import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class most_active_cookie{
	
	ArrayList<String> Jtests;
	
	private most_active_cookie(){	
		Jtests = new ArrayList<String>();
	}
	
	public most_active_cookie(String path, String date) throws Exception {
		Jtests = active_cookie(path,date);
	}
	
	public static void main(String[] args) throws Exception {  
		String path = args[0];
		String date = args[2];	
				  
		most_active_cookie cook = new most_active_cookie();
		ArrayList<String> active_cookie_result = cook.active_cookie(path, date);
			  
		for(int i=0;i<active_cookie_result.size();i++)
			System.out.println(active_cookie_result.get(i));
	}
	  
	public ArrayList<String> active_cookie(String input_path, String input_date) throws Exception {
		  if(input_date.length() !=10 || !input_path.contains(".csv"))
			  throw new Exception("Invalid date or file type. Please make the necessary changes and re-run!");
		
		  String line = "";
		  String splitBy = ",";
		  String mostActive = "";
		  int max = 1;
		  int count = 0;
		  List<Cookie> cookie = new ArrayList<Cookie>();
		  HashMap<String, List<String>> id_map = new HashMap<String, List<String>>();
		  
		  try {
		      BufferedReader br = new BufferedReader(new FileReader(input_path));
		      while ((line = br.readLine()) != null){
		    	  String[] splitid_timestamp = line.split(splitBy);
		    	  String[] splitdate_time = splitid_timestamp[1].split("T");
		    	  String cookie_id = splitid_timestamp[0];
		    	  String table_date = splitdate_time[0];
		    	  String table_time = splitdate_time[1];
		    	  
		    	  if(table_date.equals(input_date)) {
			    	  if(!id_map.containsKey(cookie_id)) {
			    		  List<String> times = new ArrayList<String>();
			    		  times.add(table_time);
			    		  id_map.put(cookie_id, times);
			    	  }
			    	  else 
			    		  id_map.get(cookie_id).add(table_time);
			    	  cookie.add(new Cookie (cookie_id, table_time));
			      }
		      }
		      br.close();
		  }
		  catch(IOException e) {
			  throw new Exception("Invalid file path. Please make the necessary changes and re-run!");  
		  }
		  
		  if(!id_map.isEmpty()) {
			  Collections.sort(cookie, new Comparator<Cookie>() {

					@Override
					public int compare(Cookie o1, Cookie o2) {
						return o2.getTime().compareTo(o1.getTime());
					}
					  
			  });
			  Object[] keymap = id_map.keySet().toArray();
			  
			  for(int i=0;i<id_map.size();i++) {
				  if(id_map.get(keymap[i]).size() > max) 
					  mostActive = (String) keymap[i];
				  else
					  count++;
			  }
			  
			  ArrayList<String> temp = new ArrayList<String>();
			  
			  if(count != keymap.length) {
				  temp.add(mostActive);
				  return temp;
			  }
			  else {
				  for(int i=0;i<cookie.size();i++)
					  temp.add(cookie.get(i).getID());
				  return temp;
			  }
		  }
		  
		  return new ArrayList<String>();
		}
	}