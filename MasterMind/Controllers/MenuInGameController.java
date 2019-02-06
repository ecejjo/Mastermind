package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class MenuInGameController extends MenuController {
	
	public MenuInGameController(GameInterface game) {
		super(game);
		playController = new PlayController(game);
		undoController = new UndoController(game);
		redoController = new RedoController(game);
		saveController = new SaveController(game, "JSON");
		exitGameController = new ExitGameController(game);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
