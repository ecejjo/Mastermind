package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class StartController extends OperationController {
	
	protected StartController(Game game) {
		super(game);
	}
	
	public void start() {
		assert this.getState() == State.INITIAL;
		this.setState(State.PLAYING);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
