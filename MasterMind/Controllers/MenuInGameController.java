package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuInGameController extends MenuController {
	
	public MenuInGameController(GameInterface game) {
		super(game);
		this.addController(State.PLAY, new PlayController(game));
		this.addController(State.UNDO, new UndoController(game));
		this.addController(State.REDO, new RedoController(game));
		this.addController(State.SAVE, new SaveController(game, "JSON"));
		this.addController(State.EXIT_GAME, new ExitGameController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
