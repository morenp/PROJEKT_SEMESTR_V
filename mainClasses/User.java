package mainClasses;

public class User extends Osoba {
	
	String email;
	String password;
	String dateOfRegistration;
	
	public User(String name, String secondName, String address, String phoneNumber, String email,
			String password, String dateOfRegistration) 
	{
		super(name, secondName, address, phoneNumber);
		this.email = email;
		this.password = password;
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}	
}
