package ds_session_3_question_2;

public class Task {
	private String job;
	private int priority;
	public Task(String job,int priority){
		this.setJob(job);
		this.setPriority(priority);
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
