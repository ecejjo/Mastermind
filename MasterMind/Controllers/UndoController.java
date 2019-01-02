package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class UndoController extends OperationController {
	
	protected UndoController(Game game) {
		super(game);
	}
	
	public boolean run() {
		assert this.game.getState() == State.UNDO;
		this.game.setState(State.MENU);
		if (game.careTaker.isPrevious()) {
			this.restoreFromMemento(game.careTaker.getPrevious());
			return true;
		}
		return false;
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
