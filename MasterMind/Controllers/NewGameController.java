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

	public void newGameRun() {
		this.game.newGame();
		this.game.setState(State.MENU);
		this.game.getCareTaker().add(this.saveToMemento());
	}

	@Override
	public void newGame() {
		masterMindView.interact(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitApp() {
		// TODO Auto-generated method stub
		
	}
}
