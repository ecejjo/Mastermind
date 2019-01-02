package MasterMind.Controllers;

import java.io.Serializable;

import MasterMind.Model.Game;

public class Memento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
