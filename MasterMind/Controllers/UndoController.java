package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class UndoController extends OperationController {
	
	protected UndoController(GameInterface game) {
		super(game);
	}
	
	public boolean run() {
		assert this.game.getState() == State.UNDOING;
		this.game.setState(State.MENU);
		if (game.getCareTaker().isPrevious()) {
			this.restoreFromMemento(game.getCareTaker().getPrevious());
			return true;
		}
		return false;
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
