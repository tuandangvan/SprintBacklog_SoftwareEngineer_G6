package Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.AccountModel;
import Services.IAccountService;
import Services.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/account/add" })
public class AccountAddController extends HttpServlet {
	IAccountService accService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-account.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			AccountModel acc = new AccountModel();
			acc.setUserName(req.getParameter("userName"));
			acc.setPassword(req.getParameter("password"));
			acc.setRole(req.getParameter("role"));

			accService.insert(acc);
			resp.sendRedirect(req.getContextPath() + "/admin/account/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
