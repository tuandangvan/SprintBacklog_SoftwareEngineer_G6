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

import Models.TopicModel;
import Services.ITopicService;
import Services.Impl.TopicServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/topic/add" })
public class TopicAddController extends HttpServlet{
	ITopicService studentService = new TopicServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-topic.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TopicModel topic = new TopicModel();

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("topicId")) {
					topic.setTopicId(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("name")) {
					topic.setTopicName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("email")) {
					topic.setDetail(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("phone")) {
					topic.setSignUpId(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("address")) {
					topic.setMajorId(item.getString("UTF-8"));
				}
			}
			studentService.insert(topic);

			resp.sendRedirect(req.getContextPath() + "/admin/student/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
