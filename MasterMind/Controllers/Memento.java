package MasterMind.Controllers;

import MasterMind.Model.Game;

public class Memento {
	
	private Game game;
	 
	public Memento(Game gameToSave)
	{
		game = gameToSave; 
	}

	public Game getSavedState()
	{
		return game; 
	}
}
