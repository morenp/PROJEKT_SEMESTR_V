package mainClasses;

public class Ticket {

	String type;
	double price;
	String status;
	String validTill;
	String ticketID;
	Seat seat;
	
	
	
	public Ticket(String type, double price, String status, String validTill, String ticketID, Seat seat) {
		this.type = type;
		this.price = price;
		this.status = status;
		this.validTill = validTill;
		this.ticketID = ticketID;
		this.seat = seat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
}
