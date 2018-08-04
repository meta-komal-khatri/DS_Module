package ds_session_2_que3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CollegeCounselling {
	private College college;
	private List<Program> programList;
	private StudentQueue<Student> studentQueue;
	CollegeCounselling(){
		college=new College();
		programList=new ArrayList<Program>();
		studentQueue=new StudentQueue<Student>();
	}
	public void fetchStudents(){
		studentQueue=college.getStudentQueue();
	}
	public void fetchPrograms(){
		programList=college.getProgram();
	}
	public void allocate(){
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File("C:\\Users\\User30\\DownLoads\\Tempa.xls"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	       WritableSheet allocatedProgramSheet = workbook.createSheet("Sheet 1", 0);
	       Label label = new Label(0, 0, "Student Name");
	       try {
			allocatedProgramSheet.addCell(label);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       label = new Label(1, 0, "Program name");
	       try {
			allocatedProgramSheet.addCell(label);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	                
	       
		fetchStudents();
		fetchPrograms();
		for(int i=0;i<studentQueue.size();i++){
			System.out.println(studentQueue.size());
			for(String preference:studentQueue.getElement().getPrefernce()){
				for(Program program:programList){
					if(preference.equals(program.getProgramName()) && program.capacityOfProgram>0){
						
						
							
					}
				}
			}
		}
		try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
