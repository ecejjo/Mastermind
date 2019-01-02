package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
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

	public void playGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.PLAYING);
	}

	public void undo() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.UNDOING);
	}

	public void redo() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.REDOING);
	}
	
	public void saveGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.SAVING);
	}
	
	public void restoreGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.RESTORING);
	}

	public void newGame() {
		assert this.game.getState() == State.MENU;
		GameLocal newGame = new GameLocal();
		game.copy(newGame);
	}
	
	public void exitGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.CONTINUE);
	}
}
