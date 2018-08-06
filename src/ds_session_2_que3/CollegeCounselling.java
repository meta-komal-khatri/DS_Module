package ds_session_2_que3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.read.biff.BiffException;
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
	public void fetchPrograms() {
		programList=college.getProgram();
	}
	public void allocate(){
		

		WritableWorkbook workbook = null ;
		try {
			workbook = Workbook.createWorkbook(new File("C:\\Users\\popla\\OneDrive\\Documents\\Tempa.ods"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		WritableSheet allocatedProgramSheet = workbook.createSheet("Sheet 1", 0);

		fetchStudents();
		fetchPrograms();
		int size=studentQueue.size();
		for(int i=0;i<size;i++){
			System.out.println(studentQueue.size());
			outer:for(String preference:studentQueue.getElement().getPrefernce()){
				for(Program program:programList){
					if(preference.equals(program.getProgramName()) && program.capacityOfProgram>0){

						try {
							System.out.println(studentQueue.getElement().getName());
							System.out.println(program.getProgramName());
							allocatedProgramSheet.addCell(new Label(0,i,studentQueue.getElement().getName()));
							allocatedProgramSheet.addCell(new Label(1,i,program.getProgramName()));
							
						} catch (RowsExceededException e) {
							
							e.printStackTrace();
						} catch (WriteException e) {
						
							e.printStackTrace();
						}
						program.capacityOfProgram--;
						studentQueue.dequeue();
						break outer;

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
