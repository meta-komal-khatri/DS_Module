package ds_session_2_que3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GetStudent {

	@Test
	public void test() {
		College college=new College();
		college.getStudentQueueFromExcel();
		college.getProgramListFromExcel();
		List<Program> program=new ArrayList<Program>();
		program=college.getProgram();
		for(Program program1:program){
			System.out.println(program1.programName);
		}
		
			System.out.println(college.getStudentQueue().size);
			
		
		CollegeCounselling collegeCounselling=new CollegeCounselling();
		collegeCounselling.allocate();
	//	StudentQueue<Student> queue=college.getStudentQueue();
		
		
	}

}
