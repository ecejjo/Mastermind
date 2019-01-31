package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ExitController extends OperationController {

	protected ExitController(GameInterface game) {
		super(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public boolean exitRun(char answer) {		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.setState(State.EXIT);
			return true;
		} else {
			this.game.setState(State.MENU);
			return false;
		}		
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restoreGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abortGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGame() {
		masterMindView.interact(this);
	}
}
