package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class StartController extends OperationController {
	
	protected StartController(Game game) {
		super(game);
	}
	
	public void start() {
		assert this.game.getState() == State.INITIAL;
		this.game.setState(State.MENU);
		this.game.careTaker.add(this.saveToMemento());
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
