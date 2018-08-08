package ds_session_2_question_6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONObjectReader {

	/**
	 * Get nested list from JSON file into JSON object
	 * @return 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public JSONObject createJsonObject() throws FileNotFoundException, IOException, ParseException{
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\User30\\Downloads\\jsonNestedList.json.txt"));
		JSONObject object = (JSONObject) obj;	
		return object;
	}
	
	/**
	 * store JSON object into nested list
	 * @param object
	 * @return NestedList
	 */
	public NestedLinkedList storeJsonNestedObjectIntoNestedList(JSONObject object){
		NestedLinkedList nestedList=new NestedLinkedList(); 
		for(Object key:object.keySet()){

			if(object.get(key) instanceof String){
				nestedList.addValue(Integer.parseInt((String) object.get(key)));
			}
			else{
				nestedList.addList(storeJsonNestedObjectIntoNestedList((JSONObject) object.get(key)).getNestedList());				
			}
		}
		return nestedList;

	}
}
