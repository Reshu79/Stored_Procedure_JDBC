package connector;


import model.Student_model;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/student")
public class student_construct extends HttpServlet{
	Student_model sm=new Student_model();
	Student_logic sl=new Student_logic();
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int ec_no=Integer.valueOf(request.getParameter("ec_no"));
		String s_name=request.getParameter("s_name");
		String feedback=request.getParameter("feedback");
		System.out.println(ec_no+s_name+feedback);
		sm.setEc_no(ec_no);
		sm.setS_name(s_name);
		sm.setFeedback(feedback);
		sl.toInsert(sm);
//		String result=
//		response.setContentType("text/plain;charset=UTF-8");
//		response.getWriter().println(result);
		response.setContentType("text/html");
		response.getWriter().println("<h1 style='color:red','font:20px';>Data Stored Successfully....</h1>");;
	}

}
