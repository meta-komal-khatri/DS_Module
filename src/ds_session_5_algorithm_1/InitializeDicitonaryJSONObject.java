package ds_session_5_algorithm_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InitializeDicitonaryJSONObject {
	
	public JSONObject createJsonObject() throws FileNotFoundException, IOException, ParseException{
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\User30\\Downloads\\Dictionary.json.txt"));
		JSONObject object = (JSONObject) obj;	
		return object;
	}
	
	
}
