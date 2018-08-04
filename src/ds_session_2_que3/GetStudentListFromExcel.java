package ds_session_2_que3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetStudentListFromExcel {
	public StudentQueue<Student> getStudentListFromExcel(){
		StudentQueue<Student> studentQueue=new StudentQueue<Student>();
		List<String> preferences;
		try{
		
			Workbook workbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\User30\\Downloads\\Student.xls"));
			Sheet sheet1 = workbook.getSheet(0);
			String studentName=null;
			String programArray = null;
			
			for(int i=0;i<sheet1.getRows();i++){
				preferences =new ArrayList<String>();
				for(int j=0;j<sheet1.getColumns();j++){
		
					if(j==0){
					studentName= sheet1.getCell(j,i).getContents();
	
					}
					else{
						programArray=sheet1.getCell(j,i).getContents();
						preferences.add(programArray);
					}
				
				
			
				}	
				studentQueue.enqueue(new Student(studentName,preferences));
				
			}
			
		} catch (BiffException biffexception) {

			biffexception.printStackTrace();

		} catch (IOException ioexception) {

			ioexception.printStackTrace();

		}
	return studentQueue;
	}
	}

