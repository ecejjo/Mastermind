package MasterMind.Controllers;

import MasterMind.Model.Game;

public class SaveController extends OperationController {
	
    private SaveControllerImpl impl;
		
	public SaveController(Game game, String format) {
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
	
	public boolean saveGame() {
		return (impl.saveGame(FILENAME));
	}
}
