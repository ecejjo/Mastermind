package MasterMind.Controllers;

import java.io.Serializable;

import MasterMind.Model.GameStandalone;

public class Memento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private GameStandalone game;
	 
	public Memento(GameStandalone gameToSave)
	{
		game = gameToSave; 
	}

	public GameStandalone getSavedState()
	{
		return game; 
	}
}
