package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.AccountLogin;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/login" })
public class ControllerLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		boolean isvalid=false;
		try {
			isvalid = AccountLogin.checkLogin (user, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (isvalid) {
			// khởi tạo cookie
			Cookie cookie = new Cookie("username", user);
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30 * 60 * 60);
			// thêm cookie vào response
			resp.addCookie(cookie);
			 //chuyển sang trang HelloServlet
			resp.sendRedirect(req.getContextPath() + "/admin/account/list");
		} else {
			// chuyển sang trang LoginServlet
			// resp.sendRedirect("/login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
