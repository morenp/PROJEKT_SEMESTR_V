package mainClasses;

public class Compartment extends TrainPart {
	
	Seat seats[];

	public Compartment(int iD, String serialNumber, Seat[] seats) {
		super(iD, serialNumber);
		this.seats = seats;
	}

	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	
	
	
	
}
