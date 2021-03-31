package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.Account;

public interface AccountDaoI {
	public void addAccount(Account account);

	public Account getAccount(int id);

	public boolean updateAccount(int id, double balance);

	public void removeAccount(int id);

	public List<Account> getAllAccounts();

}
