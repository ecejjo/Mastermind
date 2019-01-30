package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuController extends OperationController {
		
	public MenuController(GameInterface game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void newGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.NEW_GAME);
	}

	public void playGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.PLAYING);
	}
	
	public boolean inGame() {
		assert this.game.getState() == State.MENU;
		return (this.game.inGame());
	}
	
	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}

	public void undo() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.UNDOING);
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public void redo() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.REDOING);
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}

	public void saveGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.SAVING);
	}
	
	public void restoreGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.RESTORING);
	}
	
	public void abortGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.ABORT);
	}
	
	public void exitGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.CONTINUE);
	}
}
