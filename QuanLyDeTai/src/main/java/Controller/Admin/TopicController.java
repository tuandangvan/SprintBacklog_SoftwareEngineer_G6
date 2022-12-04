package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.TopicModel;
import Services.ITopicService;
import Services.Impl.TopicServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/topic/list" })
public class TopicController extends HttpServlet{
	ITopicService accService = new TopicServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TopicModel> topicList = accService.getAll();
		req.setAttribute("topicList", topicList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-topic.jsp");
		dispatcher.forward(req, resp);
	}
}
