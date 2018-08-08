package ds_session_3_question_2;

public class Task {
	private String job;
	private int priority;
	public Task(String job,int priority){
		this.setJob(job);
		this.setPriority(priority);
	}
	/**
	 * @return job name
	 */
	public String getJob() {
		return job;
	}
	/**
	 * set job name
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * get priority of task
	 * @return priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * sets priority of task
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
