package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class RedoController extends OperationController {
	
	protected RedoController(GameInterface game) {
		super(game);
	}
	
	public boolean redo() {
		this.game.setState(State.MENU);
		if (game.getCareTaker().nextExists()) {
			this.restoreFromMemento(game.getCareTaker().getNext());
			return true;
		}
		return false;
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
