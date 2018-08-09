package ds_session_5_algorithm_1;

public class Search {

	Search(){
		
	}
	public Word searchWord(Word root,String word){
		if(root==null || root.getWord().equals(word)){
			return root;
		}
		if(root.getWord().compareTo(word)>0){
			return searchWord(root.getLeftWord(),word);
		}
		return searchWord(root.getRightWord(),word);
	}
}
