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
	/**
	 * virtual command prompt
	 */
	public void virtualCommandPrompt() {

		do {
			//System.out.println("Enter Command");
			String command=sc.next();
			String directory=null;
			boolean check=false;
			switch(command) {
			
			//command cd to change directory
			case "cd":
				directory=sc.next();
				commandCd(directory, check);	
				break;
			
				//command mkdir for creating a sub folder in current directory 
			case "mkdir":
				directory=sc.next();
				commandMkdir(directory, check);
				break;
			
			//command for going back to parent folder
			case "bk":
				if(sc.next()!=null) {
					System.out.println("Invalid Command");	
				}
				else {
				commandBk();
				}
				break;
			
			//command for showing list of all sub folders present in current directory
			case "ls":
				if(sc.next()!=null) {
					System.out.println("Invalid Command");	
				}
				else {
				commandLs();
				}
				break;
				
			//command to find specified directory 
			case "find":
				directory=sc.next();
				find(pointer,directory,".");
				System.out.println(directoryScreenLine);
				break;
				
			//represent directory structure from root directory
			case "tree":
				((MyTreeNode<String>) pointer).print();
				break;
				
			//command to exit Virtual Command Prompt
			case "exit":
				System.exit(0);
				
			default:
				System.out.println("Invalid Command");
				System.out.println(directoryScreenLine);
			}
		}
		while(true);
	
	}
	/**
	 * changes the path of current directory to specified directory
	 * specified directory can be any of its children
	 * @param directory specified directory
	 * @param check
	 */
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
	
	/**
	 * create a new directory in current directory
	 * @param directory specified directory
	 * @param check false if specified directory doesn't exist else true
	 */
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
	
	/**
	 * moves to parent directory
	 * if already on root ,shows message "On Root"
	 */
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
	
	/**
	 * shows list of all directories in current directory
	 */
	private void commandLs(){
		int total=0;
		for(MyTreeNode<String> node:pointer.getChildren()){
			System.out.println(node.getDate()+"\t\t\t\t"+node.getData());
			total++;
		}
		System.out.println(total+"Folder(s)");
	}
	/**
	 * finds specified directory 
	 * @param pointer directory in which directory is being searched
	 * @param findDirectory 
	 * @param path path of specified directory
	 */
	public void find(MyTreeNode<String> pointer,String findDirectory,String path){
		if(pointer.getData().equals(findDirectory)) {
			System.out.println(path);
		}
		if(pointer.getChildren().size()>0) {
			for(MyTreeNode<String> node: pointer.getChildren()) {
				path=path.concat("/"+node.getData());
				find(node,findDirectory,path);
				path=path.replaceAll("/"+node.getData(), "");
			}
		}
		else {
			path=path.replaceAll("/"+pointer.getData(), "");
		}
		}
}
