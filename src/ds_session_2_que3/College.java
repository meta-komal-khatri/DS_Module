package ds_session_2_que3;

import java.util.LinkedList;
import java.util.List;

public class College {
	private List<Program> programList;
	GetProgramListFromExcel getProgramList;
	GetStudentListFromExcel getStudentList;
	public College() {
		programList=new LinkedList<Program>();
		getProgramList=new GetProgramListFromExcel();
		getStudentList=new GetStudentListFromExcel();
	}
	public List<Program> getProgram() {
		return programList;
	}
	public void setProgram(List<Program> program) {
		this.programList = program;
	}
	public void getListFromExcel(){
		programList=getProgramList.getProgramListFromExcel();
	}
	
	
	
}
