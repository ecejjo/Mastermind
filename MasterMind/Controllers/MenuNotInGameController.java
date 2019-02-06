package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class MenuNotInGameController extends MenuController {
	
	public MenuNotInGameController(GameInterface game) {
		super(game);
		newGameController = new NewGameController(game);
		restoreController = new RestoreController(game, "JSON");
		exitAppController = new ExitAppController(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
