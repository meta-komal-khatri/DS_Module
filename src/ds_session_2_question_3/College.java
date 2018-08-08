package ds_session_2_question_3;


import java.util.LinkedList;
import java.util.List;

public class College {
	private List<Program> programList;
	private StudentQueue<Student> studentQueue;
	GetProgramListFromExcel getProgramList;
	GetStudentListFromExcel getStudentList;
	/**
	 * college contains program list and student of list who have applied 
	 */
	public College() {
		programList=new LinkedList<Program>();
		studentQueue=new StudentQueue<Student>();
		getProgramList=new GetProgramListFromExcel();
		getStudentList=new GetStudentListFromExcel();
	}
	/**
	 * retrieve program list from excel sheet
	 * @return
	 */
	public List<Program> getProgram() {
		getProgramListFromExcel();
		return programList;
	}
	
	/**
	 *  retrieve program list from excel sheet
	 */
	public void getProgramListFromExcel() {
		programList=getProgramList.getProgramListFromExcel();
	}
	/**
	 * retrieve student queue from excel sheet
	 * @return
	 */
	public StudentQueue<Student> getStudentQueue() {
		getStudentQueueFromExcel();
		return studentQueue;
	}
	
	public void getStudentQueueFromExcel(){
		studentQueue=getStudentList.getStudentListFromExcel();
	}
	
	
}
