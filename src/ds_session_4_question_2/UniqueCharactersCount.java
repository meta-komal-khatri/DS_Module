package ds_session_4_question_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharactersCount {
	private Map<String,Integer> cachedString;
	
	/**
	 * initialize cachedString to create cache of all strings that have been input 
	 */
	public UniqueCharactersCount() {
		cachedString=new LinkedHashMap<String,Integer>();
	}
	
	/**
	 * counts unique characters in given string input
	 * example: in string "Komal" there are 5 unique characters 
	 * while in "Nanu" there are 2 unique characters
	 * @param input
	 * @return
	 */
	public int countUniqueCharactersInString(String input){
		if(input.isEmpty()) {
			throw new NullPointerException("Strin is empty");
		}
		/*checks that input exist in cachedString
		 * or not ,if yes then send result from cachedString
		 */
		if(cachedString.containsKey(input)){
			System.out.println(cachedString.get(input).toString());
			return cachedString.get(input);	
		}
		
		/*else store unique characters in characterCount ,
		 * if character is repeated set false for that key  
		 */
		else{
			 return storeCharactersInMap(input);
		}
	}
	
	/**
	 * stores character and their corresponding boolean value into hash map
	 * @param input
	 * @return count of unique character
	 */
	private int storeCharactersInMap(String input){
		Map<Character,Boolean> characterCount=new LinkedHashMap<Character,Boolean>();
		int uniqueCharacterCount;
		for(int i=0;i<input.length();i++){
			if(characterCount.containsKey(input.charAt(i))){
				characterCount.put(input.charAt(i),false);
			}
			else{
				characterCount.put(input.charAt(i), true);
			}
		}
		uniqueCharacterCount=countNumber(characterCount);
		return uniqueCharacterCount;
	}
	
	/**
	 * count number of unique characters, if key value of specific character is true increment count
	 * @param characterCount
	 * @return
	 */
	private int countNumber(Map<Character,Boolean> characterCount){
		int count=0;
		for(Map.Entry<Character, Boolean> entry:characterCount.entrySet()){
			if(entry.getValue()){
				count++;
			}
		}
		return count;
	}
}
