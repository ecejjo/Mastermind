package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ContinueController extends OperationController {

	protected ContinueController(GameInterface game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void start() {
		assert this.game.getState() == State.CONTINUE;
	}
	
	public boolean end(char answer) {
		assert this.game.getState() == State.CONTINUE;
		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.setState(State.EXIT);
			return true;
		} else {
			this.game.setState(State.MENU);
			return false;
		}		
	}
}
