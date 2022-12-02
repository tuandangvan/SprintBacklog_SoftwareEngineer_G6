package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IStudentService;
import Services.Impl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/admin/student/delete" })
public class StudentDeleteController extends HttpServlet{
	IStudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		studentService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/student/list");
	}

}
