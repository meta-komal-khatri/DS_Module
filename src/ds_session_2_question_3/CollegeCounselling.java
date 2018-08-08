package ds_session_2_question_3;

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
	
	//initialize with college and program list of college and student list
	CollegeCounselling(){
		college=new College();
		programList=new ArrayList<Program>();
		studentQueue=new StudentQueue<Student>();
	}
	/**
	 * gets student list from specific college
	 */
	public void fetchStudents(){
		studentQueue=college.getStudentQueue();
	}
	
	/**
	 * get program list from specific college
	 */
	public void fetchPrograms() {
		programList=college.getProgram();
	}
	
	/**
	 * allocates college program to students according to their preference order
	 */
	public void allocate(){
		WritableWorkbook workbook = null ;
		//store list of students name and allocated program to them
		try {
			workbook = Workbook.createWorkbook(new File("C:\\Users\\popla\\OneDrive\\Documents\\Tempa.ods"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		WritableSheet allocatedProgramSheet = workbook.createSheet("Sheet 1", 0);
		
		fetchStudents();
		fetchPrograms();
		
		for(int i=0;i<studentQueue.size();i++){
			outer:for(String preference:studentQueue.getElement().getPrefernce()){
				for(Program program:programList){
					if(preference.equals(program.getProgramName()) && program.getCapacityOfProgram()>0){

						try {
							allocatedProgramSheet.addCell(new Label(0,i,studentQueue.getElement().getName()));
							allocatedProgramSheet.addCell(new Label(1,i,program.getProgramName()));

						} catch (RowsExceededException e) {

							e.printStackTrace();
						} catch (WriteException e) {

							e.printStackTrace();
						}
						program.setCapacityOfProgram(program.getCapacityOfProgram()-1);
						studentQueue.dequeue();
						break outer;

					}
				}
			}
		}
		try {
			workbook.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
