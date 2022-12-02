package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StudentModel;
import Services.IStudentService;
import Services.Impl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/admin/student/list" })
public class StudentController extends HttpServlet{
	IStudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StudentModel> studentList = studentService.getAll();
		req.setAttribute("studentList", studentList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-student.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print(req.getParameter("abc"));
	}
	
	
}
