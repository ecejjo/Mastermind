package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class SaveController extends OperationController {
	
    private SaveControllerImpl impl;
		
	public SaveController(GameInterface game, String format) {
		super(game);
        if (format.equals("JSON")) {
            impl = new SaveJsonController(game);
        } else {
            impl = new SaveBinaryController(game);
        }
    }

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public boolean save() {
		return (impl.saveGame(FILENAME));
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
		masterMindView.interact(this);
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
