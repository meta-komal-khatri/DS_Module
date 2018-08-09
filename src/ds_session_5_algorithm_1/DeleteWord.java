package ds_session_5_algorithm_1;

public class DeleteWord {
	Search search;
	public DeleteWord() {
		search=new Search();
	}
	public Word delete(Word root,String word){
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

}
