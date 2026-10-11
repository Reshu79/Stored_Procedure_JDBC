package student_feedback;

public class Student_feedback_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(DBconnection.dbconnection());
     Student_feedback_logic.Create();
     //call like this because it is a static method
     Student_feedback_logic sfl=new Student_feedback_logic();
     sfl.inserts();//becoz it is not a static method
     sfl.update();
     Student_feedback_logic.print();
     sfl.method();

	}

}
