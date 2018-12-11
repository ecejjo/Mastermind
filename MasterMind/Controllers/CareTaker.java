package MasterMind.Controllers;

import java.util.ArrayList;

public class CareTaker {
	
	private ArrayList<Memento> savedGames;
	
	public CareTaker()
	{
		savedGames = new ArrayList<Memento>();
	}

	public void add(Memento m)
	{
		savedGames.add(m);
	}
	
	public Memento get(int index)
	{
		return savedGames.get(index);
	}
}
