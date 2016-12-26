package mainClasses;

public class Train extends TrainPart{

	Carriage carriages;

	public Train(int iD, String serialNumber, Carriage carriages) {
		super(iD, serialNumber);
		this.carriages = carriages;
	}

	public Carriage getCarriages() {
		return carriages;
	}

	public void setCarriages(Carriage carriages) {
		this.carriages = carriages;
	}
	
	
}
