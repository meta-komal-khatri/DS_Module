package ds_session_3_que_1;

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

				
				break;
			case "mkdir":
				directory=sc.next();
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
				break;
			case "bk":
				if(!pointer.getData().equals(root.getData())) {
					directoryScreenLine=directoryScreenLine.replaceAll(pointer.getData()+"//", "");
					pointer=pointer.getParent();
					System.out.println(directoryScreenLine);
				}
				else {
					System.out.println("On Root");
					System.out.println(directoryScreenLine);
				}
				break;
			default:
				System.out.println("Invalid Command");
				System.out.println(directoryScreenLine);
			}
		}
		while(true);
	}
}
