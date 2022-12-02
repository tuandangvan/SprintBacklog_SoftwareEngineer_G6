package Services;

import java.util.List;

import Models.AccountModel;

public interface IAccountService {
	void insert(AccountModel account);
	void edit(AccountModel account);
	void delete(String userName);
	AccountModel getUser(String userName);
	List<AccountModel> getAll();
}
