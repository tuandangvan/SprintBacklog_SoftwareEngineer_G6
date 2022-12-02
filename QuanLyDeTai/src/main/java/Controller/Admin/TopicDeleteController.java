package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ITopicService;
import Services.Impl.TopicServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/topic/delete" })
public class TopicDeleteController extends HttpServlet{
	ITopicService topicService = new TopicServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		topicService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/topic/list");
	}

}
