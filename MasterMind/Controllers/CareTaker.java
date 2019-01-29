package MasterMind.Controllers;

import java.io.Serializable;
import java.util.ArrayList;

public class CareTaker implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Memento> savedGames;
	
	private int current;
		
	public CareTaker()
	{
		savedGames = new ArrayList<Memento>();
		current = -1;
	}

	public void add(Memento m)
	{
		current += 1;
		savedGames.add(current, m);
	}
	
	public Memento get(int index)
	{
		return savedGames.get(index);
	}
	
	public boolean previousExists()
	{
		return (current > 0);
	}
	
	public Memento getPrevious()
	{
		current -= 1;
		return savedGames.get(current);
	}

	public boolean nextExists() {
		return (current < savedGames.size() - 1);
	}
	
	public Memento getNext()
	{
		current += 1;
		return savedGames.get(current);
	}

	public void copy(CareTaker careTaker) {
		
		this.savedGames = new ArrayList<Memento>();
		for (int i = 0; i < careTaker.savedGames.size(); i++) {
			if (careTaker.savedGames.get(i) != null) {
				this.savedGames.add(new Memento(careTaker.savedGames.get(i).getSavedState()));
			}
		}
	
		this.current = careTaker.current;
	}
}
