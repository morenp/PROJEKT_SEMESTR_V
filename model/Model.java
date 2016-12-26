package model;

import java.util.ArrayList;

import observe.Observer;
import observe.Observe;

public class Model implements Observe{

	
	private ArrayList<Observer> observers ;
	
		Model()
		{
			observers = new ArrayList<Observer>();
		}
		
	
		public void addObserver(Observer o)
		{
		observers.add(o);
		}
		 
		public void removeObserver(Observer o)
		{
		int index = observers.indexOf(o);
		observers.remove(index);
		}
		 
		public void informObservers()
		{
			for(Observer o : observers)
			{
				o.update();
			}
		}
}

	