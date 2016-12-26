package mainClasses;

public class Reservation {

	int ID;
	String date;
	double cost;
	String code;
	TicketReservation ticketReservations[];
	public Reservation(int iD, String date, double cost, String code, TicketReservation[] ticketReservations) {
		super();
		ID = iD;
		this.date = date;
		this.cost = cost;
		this.code = code;
		this.ticketReservations = ticketReservations;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public TicketReservation[] getTicketReservations() {
		return ticketReservations;
	}
	public void setTicketReservations(TicketReservation[] ticketReservations) {
		this.ticketReservations = ticketReservations;
	}
}



