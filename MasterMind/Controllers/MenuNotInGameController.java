package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuNotInGameController extends MenuController {
	
	public MenuNotInGameController(GameInterface game) {
		super(game);
		this.put(State.NEW_GAME, new NewGameController(game));
		this.put(State.RESTORE, new RestoreController(game, "JSON"));
		this.put(State.EXIT_APP, new ExitAppController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
