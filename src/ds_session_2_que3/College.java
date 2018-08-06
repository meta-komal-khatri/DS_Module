package ds_session_2_que3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jxl.read.biff.BiffException;

public class College {
	private List<Program> programList;
	private StudentQueue<Student> studentQueue;
	GetProgramListFromExcel getProgramList;
	GetStudentListFromExcel getStudentList;
	public College() {
		programList=new LinkedList<Program>();
		studentQueue=new StudentQueue<Student>();
		getProgramList=new GetProgramListFromExcel();
		getStudentList=new GetStudentListFromExcel();
	}
	public List<Program> getProgram() {
		getProgramListFromExcel();
		return programList;
	}
	
	public void getProgramListFromExcel() {
		programList=getProgramList.getProgramListFromExcel();
	}
	public StudentQueue<Student> getStudentQueue() {
		getStudentQueueFromExcel();
		return studentQueue;
	}
	
	public void getStudentQueueFromExcel(){
		studentQueue=getStudentList.getStudentListFromExcel();
	}
	
	
}
