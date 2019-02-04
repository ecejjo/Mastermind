package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class NewGameController extends OperationController {
	
	protected NewGameController(GameInterface game) {
		super(game);
	}
			
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

	public void newGame() {
		this.game.newGame();
		this.game.setState(State.MENU);
		this.game.getCareTaker().add(this.saveToMemento());
	}
}
