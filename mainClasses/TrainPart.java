package mainClasses;

public class TrainPart {

	int ID;
	String SerialNumber;
	
	public TrainPart(int iD, String serialNumber) {
		ID = iD;
		SerialNumber = serialNumber;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	
	
}
