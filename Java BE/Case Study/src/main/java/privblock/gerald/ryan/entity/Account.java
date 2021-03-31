package privblock.gerald.ryan.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account")
public class Account {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id; // primary key
	int user_id; // foreign key - account holder
	double balance;
	String currency;
	String status; // open // closed // frozen
	@Temporal(value = TemporalType.DATE)
	Date date_opened;
	@Temporal(value = TemporalType.DATE)
	Date last_accessed;

	public Account(int user_id, double balance, String currency) {
		super();
		this.user_id = user_id;
		this.balance = balance;
		this.currency = currency;
		this.date_opened = new Date();
		this.last_accessed = new Date();
	}

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate_opened() {
		return date_opened;
	}

	public void setDate_opened(Date date_opened) {
		this.date_opened = date_opened;
	}

	public Date getLast_date_accessed() {
		return last_accessed;
	}

	public void setLast_date_accessed(Date last_date_accessed) {
		this.last_accessed = last_date_accessed;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
		return String.format("%5s %5s %10s %15s %15s %15s", id, user_id, balance, currency, sm.format(date_opened),
				sm.format(last_accessed));
	}

}

//
//--entity
//---block
//---blockchain
//---account
