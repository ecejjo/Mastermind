package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ExitGameController extends OperationController {

	protected ExitGameController(GameInterface game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
		
	public boolean exitGameRun(char answer) {		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.exitGame();
			return true;
		} else {
			this.game.setState(State.MENU);
			return false;
		}		
	}
	
	public void exitGame() {
		masterMindView.interact(this);
	}
}