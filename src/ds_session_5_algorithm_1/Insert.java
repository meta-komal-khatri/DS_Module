package ds_session_5_algorithm_1;

public class Insert {
	Word root;
	Insert(Word root){
		this.root=root;
	}
	public Word insertNewWord(Word root,String word,String meaning){
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
}
