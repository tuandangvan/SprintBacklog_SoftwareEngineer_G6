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

import Models.AccountModel;
import Services.IAccountService;
import Services.Impl.AccountServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/account/edit" })
public class AccountEditController extends HttpServlet{
	IAccountService accService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("id");
		AccountModel acc = accService.getUser(userName);
		req.setAttribute("acc", acc);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-account.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountModel acc = new AccountModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("password")) {
					acc.setPassword(item.getString("UTF-8"));
					System.out.println(acc.getPassword());
				}
				else if (item.getFieldName().equals("role")){
					acc.setRole(item.getString("UTF-8"));
					System.out.println(acc.getRole());
				}
				else
				{
					acc.setUserName(item.getString("UTF-8"));
					System.out.println(acc.getUserName());
				}
				
			}
			accService.edit(acc);
			resp.sendRedirect(req.getContextPath() + "/admin/account/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
