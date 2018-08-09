package ds_session_5_algorithm_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Dictionary {
	Word root;
	JSONObject object;
	public Dictionary() throws FileNotFoundException, IOException, ParseException {
		root=null;
		InitializeDicitonaryJSONObject dicitonaryJSONObject=new InitializeDicitonaryJSONObject();
		object=dicitonaryJSONObject.createJsonObject();	
		initialize(object);
	}
	
	
	public void insertIntoDictionary(String word,String meaning){
		Insert insert=new Insert(root);
		root=insert.insertNewWord(root, word, meaning);
	}
	
	public Word searchWordMeaning(String word){
		Search search=new Search();
		Word wordMeaning=search.searchWord(root,word);
		if(wordMeaning.getWord().isEmpty()){
			throw new NoSuchElementException("Word is not available in dictionary");
		}
		return wordMeaning;
	}
	
	public void deleteWord(String word){
		DeleteWord deleteWord=new DeleteWord();
		deleteWord.delete(root,word);
	}
	private void initialize(JSONObject object){
		for(Object key:object.keySet()){
			
		}
	}
	
	
}
