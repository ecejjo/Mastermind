package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuInGameController extends MenuController {
	
	public MenuInGameController(GameInterface game) {
		super(game);
		this.put(State.PLAY, new PlayController(game));
		this.put(State.UNDO, new UndoController(game));
		this.put(State.REDO, new RedoController(game));
		this.put(State.SAVE, new SaveController(game, "JSON"));
		this.put(State.EXIT_GAME, new ExitGameController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
