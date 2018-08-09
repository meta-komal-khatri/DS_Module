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
	
	/**
	 * it basically calls insertNewWord method to insert new word in dictionary
	 * @param word 
	 * @param meaning
	 */
	public void insertIntoDictionary(String word,String meaning){
		root=insertNewWord(root, word, meaning);
	}
	
	/**
	 * inserts word into dictionary
	 * @param root root of dictionary
	 * @param word word that is to be stored
	 * @param meaning
	 * @return hierarchy of dictionary ,root node of tree
	 */
	private Word insertNewWord(Word root,String word,String meaning){
		if(root==null){
			root=new Word(word,meaning);
			return root;
		}
		
		//when word is smaller than root word,calls recursively
		if(word.compareTo(root.getWord())<0){
			root.setLeftWord(insertNewWord(root.getLeftWord(),word,meaning)); 
		}
		
		//when word is greater than root word ,calls recursively
		if(word.compareTo(root.getWord())>0){
			root.setRightWord(insertNewWord(root.getRightWord(),word,meaning));
		}
	
		return root;
	}
	/**
	 * it returns sorted list of words of dictionary,it basically calls sortedOrderDictionary method
	 * @return List of word
	 */
	public List<Word> sortedDictionary(){
		sortedDictionary=new ArrayList<Word>();
		sortedOrderDictionary(root);
		return sortedDictionary;
	}
	
	/**
	 * sorts dictionary 
	 * this method uses inorder traversing concept
	 * @param root
	 */
	private void sortedOrderDictionary(Word root){
		if(root!=null){
			sortedOrderDictionary(root.getLeftWord());
			System.out.println(root.getWord());
			sortedDictionary.add(root);
			sortedOrderDictionary(root.getRightWord());
		}	
	}
	
	/**
	 * it calls serchWord method
	 * @param word
	 * @return meaning of word if exist
	 * @throws NoSuchElementException when word is not in dictionary
	 */
	public String searchWordMeaning(String word){
		if(searchWord(root,word)==null){
			throw new NoSuchElementException("Word is not available in dictionary");
		}
		
		return searchWord(root,word).getMeaning();
	}
	
	/**
	 * it searches given word in dictionary
	 * if word is smaller that root not it search it in left tree else right tree
	 * and if root is equal to word then returns Word else null
	 * @param root
	 * @param word
	 * @return
	 */
	private Word searchWord(Word root,String word){
		if(root==null || root.getWord().equals(word)){	
			return root;
		}
		if(root.getWord().compareTo(word)>0){
			return searchWord(root.getLeftWord(),word);
		}
		return searchWord(root.getRightWord(),word);
		
	}
	
	/**
	 * it calls delete method
	 * it also checks whether word exist or not 
	 * if not throw NoSuchElementException
	 * @param word
	 */
	public void deleteWord(String word){
		searchWordMeaning(word);
		root=delete(root,word);
	}
	
	/**
	 * it deletes specific word from dictionary
	 * @param root
	 * @param word
	 * @return newly created hierarchy of dictionary
	 */
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
				return root.getRightWord();
						
			}
			if(root.getRightWord()==null){
				return root.getLeftWord();
			}
			root.setWord(minValueWord(root.getRightWord()).getWord());
			root.setMeaning(minValueWord(root.getRightWord()).getMeaning());
			root.setRightWord(delete(root.getRightWord(),root.getWord()));
			
		}
		return root;
	}
	
	/**
	 * finds the minimum value in right tree 
	 * @param root
	 * @return reference of node containing minimum value
	 */
	public Word minValueWord(Word root){
		while(root.getLeftWord()!=null){
			root=root.getLeftWord();
		}
		return root;
	}
	
	/**
	 * it initializes dictionary with JSONObject values
	 * it retrieves value from JSON and insert them into dictionary 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private void initialize() throws FileNotFoundException, IOException, ParseException{
		InitializeDicitonaryJSONObject dicitonaryJSONObject=new InitializeDicitonaryJSONObject();
		object=dicitonaryJSONObject.createJsonObject();
		for(Object key:object.keySet()){
			insertIntoDictionary(key.toString(), object.get(key).toString());
		}
	}
	
	/**
	 * returns a list of words within specific range,in sorted order
	 * @param wordRange1
	 * @param wordRange2
	 * @return
	 */
	public List<Word> dictionaryWordsWithinRange(String wordRange1,String wordRange2){
		sortedDictionary=new ArrayList<Word>();
		wordsWithinRange(root, wordRange1, wordRange2);
		if(sortedDictionary.size()==0) {
			throw new NoSuchElementException();
		}
		return sortedDictionary;
		
	}
	
	/**
	 * perform sorting operation on words that are within range
	 * @param root
	 * @param wordRange1
	 * @param wordRange2
	 */
	private void wordsWithinRange(Word root,String wordRange1,String wordRange2) {
		if(root!=null) {
			if(root.getWord().compareTo(wordRange1)>0) {
				wordsWithinRange(root.getLeftWord(),wordRange1,wordRange2);
			}
			if(root.getWord().compareTo(wordRange1)>=0 && root.getWord().compareTo(wordRange2)<=0) {
				sortedDictionary.add(root);
			}
			if(root.getWord().compareTo(wordRange2)<0) {
				wordsWithinRange(root.getRightWord(), wordRange1, wordRange2);
			}
		}
	 
	}
}	
	
