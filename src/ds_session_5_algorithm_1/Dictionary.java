package ds_session_5_algorithm_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Dictionary {
	Word root;
	JSONObject object;
	List<Word> sortedDictionary;
	public Dictionary() throws FileNotFoundException, IOException, ParseException {
		
		root=null;
		initialize();
		
	}
	
	
	public void insertIntoDictionary(String word,String meaning){
		root=insertNewWord(root, word, meaning);
	}
	
	public List<Word> sortedDictionary(){
		sortedDictionary=new ArrayList<Word>();
		sortedOrderDictionary(root);
		return sortedDictionary;
	}
	public void sortedOrderDictionary(Word root){
		if(root!=null){
			sortedOrderDictionary(root.getLeftWord());
			sortedDictionary.add(root);
			System.out.println(root.getWord());
			sortedOrderDictionary(root.getRightWord());
		}	
		}
	private Word insertNewWord(Word root,String word,String meaning){
		if(root==null){
			root=new Word(word,meaning);
			return root;
		}
		if(word.compareTo(root.getWord())<0){
			root.setLeftWord(insertNewWord(root.getLeftWord(),word,meaning)); 
		}
		if(word.compareTo(root.getWord())>0){
			root.setRightWord(insertNewWord(root.getRightWord(),word,meaning));
		}
	
		return root;
	}
	
	public String searchWordMeaning(String word){
		Word wordMeaning=searchWord(root,word);
		
		if(wordMeaning==null){
			throw new NoSuchElementException("Word is not available in dictionary");
		}
		return wordMeaning.getMeaning();
	}
	
	private Word searchWord(Word root,String word){
		if(root==null || root.getWord().equals(word)){	
			return root;
		}
		if(root.getWord().compareTo(word)>0){
			return searchWord(root.getLeftWord(),word);
		}
		return searchWord(root.getRightWord(),word);
		
	}
	
	public void deleteWord(String word){
		root=delete(root,word);
	}
	
	private Word delete(Word root,String word){
		if(root==null){
			return root;
		}
		if(word.compareTo(root.getWord())<0){
			root.setLeftWord(delete(root.getLeftWord(),word));
		}
		else if(word.compareTo(root.getWord())>0){
			root.setRightWord(delete(root.getRightWord(), word));
		}
		else{
			if(root.getLeftWord()==null){
				return root.getLeftWord();
						
			}
			if(root.getRightWord()==null){
				return root.getRightWord();
			}
			root.setWord(minValueWord(root.getRightWord()).getWord());
			root.setMeaning(minValueWord(root.getRightWord()).getMeaning());
			root.setRightWord(delete(root.getRightWord(),root.getWord()));
			
		}
		return root;
	}
	public Word minValueWord(Word root){
		while(root.getLeftWord()==null){
			root=root.getLeftWord();
		}
		return root;
	}
	
	private void initialize() throws FileNotFoundException, IOException, ParseException{
		InitializeDicitonaryJSONObject dicitonaryJSONObject=new InitializeDicitonaryJSONObject();
		object=dicitonaryJSONObject.createJsonObject();
		for(Object key:object.keySet()){
			insertIntoDictionary(key.toString(), object.get(key).toString());
		}
	}
	
	
}
