package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public abstract void control();
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}

	protected void print() {
		game.print();		
	}

	protected void clear() {
		game.clear();		
	}
	
	protected boolean isWinner() {
		return game.isWinner();
	}
	
	public boolean moreTries() {
		return game.moreTries();
	}	
	
	protected void read() {
		game.read();
	}
	
	protected Game getGame(){
		return game;
	}

}
