package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ExitAppController extends OperationController {

	protected ExitAppController(GameInterface game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public boolean exitAppRun(char answer) {		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.setState(State.EXIT);
			return true;
		} else {
			this.game.setState(State.MENU);
			return false;
		}		
	}
	
	public void exitApp() {
		masterMindView.interact(this);
	}
}
