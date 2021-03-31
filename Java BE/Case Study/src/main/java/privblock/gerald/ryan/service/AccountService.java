package privblock.gerald.ryan.service;

import java.util.List;

import privblock.gerald.ryan.dao.AccountDao;
import privblock.gerald.ryan.entity.Account;

public class AccountService {
	private AccountDao AccountD = new AccountDao();
	
	public void addAccountService(Account account) {
		AccountD.addAccount(account);
	}
	
	public Account getAccountService(int id) {
		return AccountD.getAccount(id);
	}
	
	public boolean updateAccountService(int id, double balance) {
		return AccountD.updateAccount(id, balance);
	}
	
	public void removeAccountService(int id) {
		AccountD.removeAccount(id);
	}
	public List<Account> getAllAccountsService(){
		return AccountD.getAllAccounts();
	}

}
