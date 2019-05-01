package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class MenuNotInGameController extends MenuController {
	
	public MenuNotInGameController(GameInterface game) {
		super(game);
		this.put(ControllerEnum.NEW_GAME, new NewGameController(game));
		this.put(ControllerEnum.RESTORE, new RestoreController(game, "JSON"));
		this.put(ControllerEnum.EXIT_APP, new ExitAppController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
