package ds_session_3_question_1;

import java.util.Scanner;

public class CommandPrompt {
	Scanner sc=new Scanner(System.in);
	MyTreeNode<String> pointer;
	MyTreeNode<String> root;
	String directoryScreenLine;
	CommandPrompt(){
		root=new MyTreeNode<String>("R");
		pointer=root;
		directoryScreenLine=root.getData()+"//";
		System.out.println(directoryScreenLine);
	}
	public void print() {

	}
	public void virtualCommandPrompt() {

		do {
			//System.out.println("Enter Command");
			String command=sc.next();
			String directory=null;
			boolean check=false;
			switch(command) {
			case "cd":
				directory=sc.next();
				commandCd(directory, check);	
				break;
			case "mkdir":
				directory=sc.next();
				commandMkdir(directory, check);
				break;
			case "bk":
				commandBk();
				break;
			case "ls":
				commandLs();
				break;
			case "find":
				
			default:
				System.out.println("Invalid Command");
				System.out.println(directoryScreenLine);
			}
		}
		while(true);
	
	}
	private void commandCd(String directory,boolean check){
		for(MyTreeNode<String> node:pointer.getChildren()) {
			if(node.getData().equals(directory)) {
				check=true;
				pointer=node;
				directoryScreenLine=directoryScreenLine.concat(node.getData()+"//");
				System.out.println(directoryScreenLine);
				break;
			}
		}
		if(!check) {
			System.out.println("Invalid Directory");
			System.out.println(directoryScreenLine);
		}
	}
	private void commandMkdir(String directory,boolean check){
		for(MyTreeNode<String> node:pointer.getChildren()) {
			if(node.getData().equals(directory)) {
				check=true;
				break;
			}
		}
		if(check) {
			System.out.println("Directory Already exist");
			System.out.println(directoryScreenLine);

		}
		else {
			pointer.addChild(directory);
			System.out.println("Directory Created");
			System.out.println(directoryScreenLine);
		}
	}
	private void commandBk(){
		if(!pointer.getData().equals(root.getData())) {
			directoryScreenLine=directoryScreenLine.replaceAll(pointer.getData()+"//", "");
			pointer=pointer.getParent();
			System.out.println(directoryScreenLine);
		}
		else {
			System.out.println("On Root");
			System.out.println(directoryScreenLine);
		}
	}
	private void commandLs(){
		for(MyTreeNode<String> node:pointer.getChildren()){
			System.out.println(node.getDate()+"\t\t"+node.getChildren().size()+"\t\t"+node.getData());
		}
		System.out.println(directoryScreenLine);
	}
	public void find(MyTreeNode<String> nodeTrack,String findDirectory){
		for(MyTreeNode<String> node : nodeTrack.getChildren()){
			if(node.getChildren().size()>0){
				find(node,findDirectory);
			}
			if(node.getData().equals(findDirectory)){
				System.out.println("");
			}
		}
		}
}
