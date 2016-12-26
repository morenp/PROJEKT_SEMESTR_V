package mainClasses;



import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.annotation.XmlRootElement;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;




@XmlRootElement(name="AppUser")
public class AppUser extends Person {
	
	
	String userID;
	
	String email;
	
	String password;
	
	String dateOfRegistration;
	//Reservation reservations[];
	
	
	public AppUser()
	{
		super();
	}
	
	public AppUser(String name, String secondName, String address, String phoneNumber)
	{
		super(name, secondName, address, phoneNumber);
	}
	
	public AppUser(String name, String secondName, String address, String phoneNumber, String userID, String email,
			String password, String dateOfRegistration/*,Reservation[] reservations*/) {
		super(name, secondName, address, phoneNumber);
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.dateOfRegistration = dateOfRegistration;
	//	this.reservations = reservations;
	}


	public Element getXML()
	{
		Element appUser = new Element("appUser");
		
		Element name = new Element("name");
		name.appendChild(super.getName());
		
		Element secondName = new Element("secondName");
		secondName.appendChild(super.getSecondName()); 
		
		Element phoneNumber = new Element("phoneNumber");
		phoneNumber.appendChild(super.getPhoneNumber());
		
		Element address = new Element("address");
		address.appendChild(super.getAddress());
		
		Element userId = new Element("userID");
		userId.appendChild(this.userID);
		
		Element email = new Element("email");
		email.appendChild(this.email);
		
		
		Element password = new Element("password");
		password.appendChild(this.password);
		
		Element dateOfRegistration = new Element("dateOfRegistration");
		dateOfRegistration.appendChild(this.dateOfRegistration);
			
		
		appUser.appendChild(name);	
		appUser.appendChild(secondName);
		appUser.appendChild(phoneNumber);
		appUser.appendChild(address);
		appUser.appendChild(userId);
		appUser.appendChild(email);
		appUser.appendChild(password);
		appUser.appendChild(dateOfRegistration);
		
		return appUser;
	}
	
	public void format(OutputStream os, Document doc) throws IOException 
	{
		Serializer serializer = new Serializer(os,"Windows-1250");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
			
	}
	
	public String toXML() throws IOException
	{
		Element root = new Element("appUser");
		root.appendChild(this.getXML());
		Document doc = new Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream("appUser.xml")),doc);

		
		return doc.toString();
		
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
//	@XmlAttribute(name="dateOfRegistration") 
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	@Override
	public String toString() {
		return "AppUser [userID=" + userID + ", email=" + email + ", password=" + password + ", dateOfRegistration="
				+ dateOfRegistration + "]";
	}

/*	public Reservation[] getReservations() {
		return reservations;
	}

	public void setReservations(Reservation[] reservations) {
		this.reservations = reservations;
	}	*/
	
	
}
