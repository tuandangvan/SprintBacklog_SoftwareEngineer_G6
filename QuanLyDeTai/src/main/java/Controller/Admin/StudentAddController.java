package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Models.StudentModel;
import Services.IStudentService;
import Services.Impl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/admin/student/add" })
public class StudentAddController extends HttpServlet {
	IStudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-student.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentModel student = new StudentModel();

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("mssv")) {
					student.setStudentId(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("name")) {
					student.setStudentName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					student.setEmail(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("phone")) {
					student.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("address")) {
					student.setAddress(item.getString("UTF-8"));
				}
			}
			studentService.insert(student);

			resp.sendRedirect(req.getContextPath() + "/admin/student/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
