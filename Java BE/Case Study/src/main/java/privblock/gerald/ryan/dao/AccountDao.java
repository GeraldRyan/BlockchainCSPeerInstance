package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.dbConnection.DBConnection;
import privblock.gerald.ryan.entity.Account;

public class AccountDao extends DBConnection implements AccountDaoI {

	@Override
	public void addAccount(Account account) {
		this.connect();
		em.getTransaction().begin();
		em.persist(account); //void persist(Object entity) Make an instance managed and persistent.
		em.getTransaction().commit();
		this.disconnect();
	}

	@Override
	public Account getAccount(int id) {
		this.connect();
		Account a = em.find(Account.class, id);
		this.disconnect();
		return a;
	}

	@Override
	public boolean updateAccount(int id, double balance) {
		this.connect();
		em.getTransaction().begin();
		Account a = em.find(Account.class, id);
		if (a != null) {
			a.setBalance(balance); // TODO implement the rest
			em.getTransaction().commit();
			this.disconnect();
			return true;
		}
		else {
			System.out.println("Account not found"); 
			this.disconnect();
			return false; // TODO change to throw error
		}
	}

	@Override
	public void removeAccount(int id) {
		this.connect();
		Account a = em.find(Account.class, id);
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		this.disconnect();
	}

	@Override
	public List<Account> getAllAccounts() {
		this.connect();
		List<Account> list_of_accounts = em.createQuery("select a from Account a").getResultList();
		this.disconnect();
		return list_of_accounts;
	}

}
