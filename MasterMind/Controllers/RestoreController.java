package MasterMind.Controllers;

import MasterMind.Model.Game;

public class RestoreController extends OperationController {
	
    private RestoreControllerImpl impl;

	public RestoreController(Game game, String format) {
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
	
	public boolean restoreGame() {
		return (impl.restoreGame(FILENAME));
	}
}
