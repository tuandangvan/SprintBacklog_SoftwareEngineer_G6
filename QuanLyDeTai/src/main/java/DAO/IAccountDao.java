package DAO;

import java.util.List;

import Models.AccountModel;


public interface IAccountDao {
	void insert(AccountModel account);
	void edit(AccountModel account);
	void delete(String userName);
	AccountModel getUser(String userName);
	List<AccountModel> getAll();
//	List<AccountModel> findAll();
//	AccountModel findById(int account);
}
