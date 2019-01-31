package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class UndoController extends OperationController {
	
	protected UndoController(GameInterface game) {
		super(game);
	}
	
	public boolean run() {
		assert this.game.getState() == State.UNDOING;
		this.game.setState(State.MENU);
		if (game.getCareTaker().previousExists()) {
			this.restoreFromMemento(game.getCareTaker().getPrevious());
			return true;
		}
		return false;
	}
		
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
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
		masterMindView.interact(this);
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
		// TODO Auto-generated method stub
		
	}

}
