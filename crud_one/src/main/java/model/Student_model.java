package model;

public class Student_model {
	int ec_no;
	String s_name;
	String feedback;
	public int getEc_no() {
		return ec_no;
	}
	public void setEc_no(int ec_no) {
		this.ec_no = ec_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Student_model() {//this default construtor is needed
		
	}

}
