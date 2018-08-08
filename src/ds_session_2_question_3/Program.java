package ds_session_2_question_3;

public class Program{
	private String programName;
	private int capacityOfProgram;
	/**
	 * @param programName
	 * @param capacityOfProgram
	 */
	Program(String programName, int capacityOfProgram) {
		this.programName = programName;
		this.capacityOfProgram = capacityOfProgram;
	}
	/**
	 * @return program name of current program
	 */
	public String getProgramName() {
		return programName;
	}
	/**
	 * @param programName set program name of current program
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	/**
	 * @return capacity of current program
	 */
	public int getCapacityOfProgram() {
		return capacityOfProgram;
	}
	/**
	 * set capacity of current program
	 * @param p
	 */
	public void setCapacityOfProgram(int capacityOfProgram) {
		this.capacityOfProgram = capacityOfProgram;
	}
	
	
}
