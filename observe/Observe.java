package observe;

public interface Observe {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void informObservers();
}
