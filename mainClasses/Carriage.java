package mainClasses;

public class Carriage extends TrainPart {

	Compartment compartments;

	public Carriage(int iD, String serialNumber, Compartment compartments) {
		super(iD, serialNumber);
		this.compartments = compartments;
	}

	public Compartment getCompartments() {
		return compartments;
	}

	public void setCompartments(Compartment compartments) {
		this.compartments = compartments;
	}
	
	
	
}
