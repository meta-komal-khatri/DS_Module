package ds_session_4_question_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharactersCount {
	Map<String,Integer> cachedString;
	public UniqueCharactersCount() {
		cachedString=new LinkedHashMap<String,Integer>();
	}
	public int countUniqueCharactersInString(String input){
		Map<Character,Boolean> characterCount=new LinkedHashMap<Character,Boolean>();
		if(cachedString.containsKey(input)){
			System.out.println(cachedString.get(input).toString());
			return cachedString.get(input);
			
		}
		else{
			for(int i=0;i<input.length();i++){
				if(characterCount.containsKey(input.charAt(i))){
					characterCount.put(input.charAt(i),false);
				}
				else{
					characterCount.put(input.charAt(i), true);
				}
			}
		}
		int uniqueCharacterCount=countNumber(characterCount);
		cachedString.put(input,uniqueCharacterCount);
		return uniqueCharacterCount;
	}
	private int countNumber(Map<Character,Boolean> count){
		int count1=0;
		for(Map.Entry<Character, Boolean> c:count.entrySet()){
			if(c.getValue()){
				count1++;
			}
		}
		return count1;
	}
}
