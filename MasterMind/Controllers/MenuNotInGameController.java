package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuNotInGameController extends MenuController {
	
	public MenuNotInGameController(GameInterface game) {
		super(game);
		this.addController(State.NEW_GAME, new NewGameController(game));
		this.addController(State.RESTORE, new RestoreController(game, "JSON"));
		this.addController(State.EXIT_APP, new ExitAppController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
