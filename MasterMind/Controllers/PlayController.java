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

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playGame() {
		masterMindView.interact(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restoreGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abortGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}	
}
