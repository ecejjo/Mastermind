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
		if (game.careTaker.isPrevious()) {
			this.restoreFromMemento(game.careTaker.getPrevious());
		}
	}

	public void redo() {
		assert this.game.getState() == State.MENU;
		if (game.careTaker.isNext()) {
			this.restoreFromMemento(game.careTaker.getNext());
		}
	}

	public void endGame() {
		Game newGame = new Game();
		game.copy(newGame);
	}

	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	public void restoreGame() {
		// TODO Auto-generated method stub
		
	}	
}
