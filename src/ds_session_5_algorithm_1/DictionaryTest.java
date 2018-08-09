package ds_session_5_algorithm_1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class DictionaryTest {
	
	
	@Test
	public void insertionTest() throws FileNotFoundException, IOException, ParseException {
		Dictionary dictionary=new Dictionary();
		
		//List is retrieved from JSONObject
		List<Word> dictionaryList=dictionary.sortedDictionary();
		List<String> expecteddictionary=new ArrayList<String>(Arrays.asList("Aficionados","Akshit","Determinant","Stable"));
		
		//sorted dictionary
		for(int i=0;i<expecteddictionary.size();i++){
			assertEquals(expecteddictionary.get(i),dictionaryList.get(i).getWord());
		}
		
		dictionary.insertIntoDictionary("Summer","Vacation");
		dictionary.insertIntoDictionary("Komal","Khatri");
		
		//After adding elements into dictionary
		dictionaryList=dictionary.sortedDictionary();
		expecteddictionary=new ArrayList<String>(Arrays.asList("Aficionados","Akshit","Determinant","Komal","Stable","Summer"));
		
		//Sorted dictionary
		for(int i=0;i<expecteddictionary.size();i++){
			assertEquals(expecteddictionary.get(i),dictionaryList.get(i).getWord());
		}
		
		//search a word 
		assertEquals("Enthusiastic",dictionary.searchWordMeaning("Aficionados"));
		assertEquals("Khatri",dictionary.searchWordMeaning("Komal"));
		
		//throws NoSuchElementException if word is not in dictionary
		try {
			assertEquals("Khatri",dictionary.searchWordMeaning("Komal"));
		}
		catch(NoSuchElementException exception) {
			assertEquals("Word is not available in dictionary", exception.getMessage());
		}
		
		//search word within range,and expected result is sorted
		expecteddictionary=new ArrayList<String>
		(Arrays.asList("Akshit","Determinant","Komal"));
		for(int i=0;i<expecteddictionary.size();i++) {
			assertEquals(expecteddictionary.get(i),dictionary.dictionaryWordsWithinRange("Agsha", "Rohit").get(i).getWord());
		}
		
		//delete a word from dictionary
		dictionary.deleteWord("Aficionados");
		dictionary.deleteWord("Stable");
		dictionary.deleteWord("Summer");
		try {
		dictionary.deleteWord("Khatri");
		}
		catch(NoSuchElementException exception) {
			assertEquals("Word is not available in dictionary", exception.getMessage());
		}
		
		dictionaryList=dictionary.sortedDictionary();
		for(int i=0;i<expecteddictionary.size();i++){
			assertEquals(expecteddictionary.get(i),dictionaryList.get(i).getWord());
		}
		
		
	}

}
