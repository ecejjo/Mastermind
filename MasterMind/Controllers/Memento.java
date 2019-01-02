package MasterMind.Controllers;

import java.io.Serializable;

import MasterMind.Model.GameLocal;

public class Memento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private GameLocal game;
	 
	public Memento(GameLocal gameToSave)
	{
		game = gameToSave; 
	}

	public GameLocal getSavedState()
	{
		return game; 
	}
}
