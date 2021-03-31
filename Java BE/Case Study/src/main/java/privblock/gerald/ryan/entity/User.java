package privblock.gerald.ryan.entity;

public class User {
	int id;
	String first_name;
	String last_name;
	String middle_initial;
	String country;
	long date_registered;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getMiddle_initial() {
		return middle_initial;
	}



	public void setMiddle_initial(String middle_initial) {
		this.middle_initial = middle_initial;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public long getDate_registered() {
		return date_registered;
	}



	public void setDate_registered(long date_registered) {
		this.date_registered = date_registered;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", middle_initial="
				+ middle_initial + ", country=" + country + ", date_registered=" + date_registered + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
