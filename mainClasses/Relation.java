package mainClasses;

public class Relation {
	
	int ID;
	Station stationFrom;
	Station stationTo;
	
	public Relation(int iD, Station stationFrom, Station stationTo) {
		super();
		ID = iD;
		this.stationFrom = stationFrom;
		this.stationTo = stationTo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Station getStationFrom() {
		return stationFrom;
	}

	public void setStationFrom(Station stationFrom) {
		this.stationFrom = stationFrom;
	}

	public Station getStationTo() {
		return stationTo;
	}

	public void setStationTo(Station stationTo) {
		this.stationTo = stationTo;
	}
}
