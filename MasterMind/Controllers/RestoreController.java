package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class RestoreController extends OperationController {
	
    private RestoreControllerImpl impl;

	public RestoreController(GameInterface game, String format) {
		super(game);
        if (format.equals("JSON")) {
            impl = new RestoreJsonController(game);
        } else {
            impl = new RestoreBinaryController(game);
        }
    }

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public boolean restore() {
		return (impl.restoreGame(FILENAME));
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
		masterMindView.interact(this);
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
