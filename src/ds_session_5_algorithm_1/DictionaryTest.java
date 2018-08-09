package ds_session_5_algorithm_1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class DictionaryTest {
	
	
	@Test
	public void insertionTest() throws FileNotFoundException, IOException, ParseException {
		Dictionary dictionary=new Dictionary();
		
		//List is retrieved from JSONObject
		List<Word> dictionaryList=dictionary.sortedDictionary();
		List<String> expecteddictionary=new ArrayList<String>(Arrays.asList("Aficionados","Akshita","Determinant","Stable"));
		
		//sorted dictionary
		for(int i=0;i<expecteddictionary.size();i++){
			assertEquals(expecteddictionary.get(i),dictionaryList.get(i).getWord());
		}
		
		dictionary.insertIntoDictionary("Summer","Vacation");
		dictionary.insertIntoDictionary("Komal","Khatri");
		
		//After adding elements into dictionary
		dictionaryList=dictionary.sortedDictionary();
		expecteddictionary=new ArrayList<String>(Arrays.asList("Aficionados","Akshita","Determinant","Komal","Stable","Summer"));
		
		//Sorted dictionary
		for(int i=0;i<expecteddictionary.size();i++){
			assertEquals(expecteddictionary.get(i),dictionaryList.get(i).getWord());
		}
		
		/* 
		assertEquals("Enthusiastic",dictionary.searchWordMeaning("Aficionados"));
		assertEquals("Komal",dictionary.searchWordMeaning("Khatri"));
		*/
	}

}
