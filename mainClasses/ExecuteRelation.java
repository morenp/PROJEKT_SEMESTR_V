package mainClasses;

import java.sql.Time;
import java.util.Date;

public class ExecuteRelation {

	int ID;
	String SerialNumber;
	Train trains[];
	Relation relation;
	Ticket tickets;
	Time timeFrom;
	Time timeTo;
	Date dateFrom;
	Date dateTo;
	
	
	public ExecuteRelation(){}

	public ExecuteRelation(int iD, String serialNumber, Train[] trains, Relation relation, Ticket tickets,
			Time timeFrom, Time timeTo, Date dateFrom, Date dateTo) {
		ID = iD;
		SerialNumber = serialNumber;
		this.trains = trains;
		this.relation = relation;
		this.tickets = tickets;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
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
	public Train[] getTrains() {
		return trains;
	}
	public void setTrains(Train[] trains) {
		this.trains = trains;
	}
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	public Ticket getTickets() {
		return tickets;
	}
	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}
	public Time getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Time getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	
	
	
}
