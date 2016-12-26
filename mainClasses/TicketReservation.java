package mainClasses;

public class TicketReservation {

	int ID;
	Ticket ticket;
	public TicketReservation(int iD, Ticket ticket) {
		super();
		ID = iD;
		this.ticket = ticket;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
