package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.State;

public class PlayController extends Controller {
		
	public PlayController(GameInterface game) {
		super(game);		
	}	
	
	public void add(ProposedCombination proposedCombination) {
		this.game.add(proposedCombination);
		this.game.calculateResult();
	}
	
	public void saveGame() {
		this.game.getCareTaker().add(this.saveToMemento());
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}
	
	public boolean moreTries() {
		return game.moreTries();
	}
	
	public void done() {
		this.game.setState(State.MENU_IN_GAME);
	}

	public void playGame() {
		// ? masterMindView.interact(this);		
	}
}
