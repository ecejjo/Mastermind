package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class AbortController extends OperationController {

	protected AbortController(GameInterface game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void start() {
		assert this.game.getState() == State.ABORT;
	}
	
	public boolean abort(char answer) {
		assert this.game.getState() == State.ABORT;
		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.abortGame();
			return true;
		} else {
			this.game.setState(State.MENU);
			return false;
		}		
	}
}