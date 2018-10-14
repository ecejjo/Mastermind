package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class ContinueController extends OperationController {

	protected ContinueController(Game game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void start() {
		assert this.getState() == State.FINAL;
	}
	
	public void end(char answer) {
		assert this.getState() == State.FINAL;
		
		if (answer == 's') {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}		
	}
}
