package MasterMind.Controllers;

import java.util.ArrayList;

public class CareTaker {
	
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
	
	public boolean isPrevious()
	{
		return (current > 0);
	}
	
	public Memento getPrevious()
	{
		current -= 1;
		return savedGames.get(current);
	}

	public boolean isNext() {
		return (current < savedGames.size() - 1);
	}
	
	public Memento getNext()
	{
		current += 1;
		return savedGames.get(current);
	}
}
