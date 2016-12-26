package mainClasses;

public class Station {
	
	int ID;
	String name;
	String city;
	String address;
	public Station(int iD, String name, String city, String address) {
		super();
		ID = iD;
		this.name = name;
		this.city = city;
		this.address = address;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}


