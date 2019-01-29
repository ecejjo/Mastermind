package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.State;

public class PlayController extends OperationController {
		
	public PlayController(GameInterface game) {
		super(game);		
	}	
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void add(ProposedCombination proposedCombination) {
		assert this.game.getState() == State.PLAYING;
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
		this.game.setState(State.MENU);
	}	
	
	public void endGame() {
		this.game.setState(State.ABORT);
	}	
}
