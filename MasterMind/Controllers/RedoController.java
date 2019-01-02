package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class RedoController extends OperationController {
	
	protected RedoController(Game game) {
		super(game);
	}
	
	public boolean run() {
		assert this.game.getState() == State.REDOING;
		this.game.setState(State.MENU);
		if (game.careTaker.isNext()) {
			this.restoreFromMemento(game.careTaker.getNext());
			return true;
		}
		return false;
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
