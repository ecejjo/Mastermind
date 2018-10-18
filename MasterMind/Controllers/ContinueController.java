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
		assert this.game.getState() == State.FINAL;
	}
	
	public void end(char answer) {
		assert this.game.getState() == State.FINAL;
		
		if (answer == 's') {
			this.game.clear();
			this.game.setState(State.INITIAL);
		} else {
			this.game.setState(State.EXIT);
		}		
	}
}
