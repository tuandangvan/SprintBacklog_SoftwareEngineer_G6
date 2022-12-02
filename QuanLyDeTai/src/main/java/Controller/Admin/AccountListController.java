package Controller.Admin;

import java.io.IOException;
import java.util.List;

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
@WebServlet(urlPatterns = { "/admin/account/list" })
public class AccountListController extends HttpServlet{
	IAccountService accService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AccountModel> accList = accService.getAll();
		req.setAttribute("accList", accList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-account.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
