package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class MenuController extends OperationController {
		
	public MenuController(Game game) {
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
		if (game.careTaker.isPenultimate()) {
			this.restoreFromMemento(game.careTaker.getPenultimate());
		}
	}

	public void redo() {
		// TODO Auto-generated method stub
	}

	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	public void restoreGame() {
		// TODO Auto-generated method stub
		
	}	
}
