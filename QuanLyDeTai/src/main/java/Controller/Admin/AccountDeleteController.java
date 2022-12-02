package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IAccountService;
import Services.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/account/delete" })
public class AccountDeleteController extends HttpServlet{

	IAccountService accService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		accService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/account/list");
	}

}
