package Services.Impl;

import java.util.List;

import DAO.IAccountDao;
import DAO.Impl.AccountDaoImpl;
import Models.AccountModel;
import Services.IAccountService;

public class AccountServiceImpl implements IAccountService{

	IAccountDao acc = new AccountDaoImpl();
	@Override
	public void insert(AccountModel account) {
		// TODO Auto-generated method stub
		acc.insert(account);
	}

	@Override
	public void edit(AccountModel account) {
		// TODO Auto-generated method stub
		acc.edit(account);
	}

	@Override
	public void delete(String userName) {
		// TODO Auto-generated method stub
		acc.delete(userName);
	}

	@Override
	public AccountModel getUser(String userName) {
		// TODO Auto-generated method stub
		return acc.getUser(userName);
	}

	@Override
	public List<AccountModel> getAll() {
		// TODO Auto-generated method stub
		return acc.getAll();
	}

}
