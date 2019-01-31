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
	public void exitGame() {
		masterMindView.interact(this);
	}

	@Override
	public void exitApp() {
		// TODO Auto-generated method stub
		
	}	
}