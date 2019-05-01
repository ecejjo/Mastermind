package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class MenuInGameController extends MenuController {
	
	public MenuInGameController(GameInterface game) {
		super(game);
		this.put(ControllerEnum.PLAY, new PlayController(game));
		this.put(ControllerEnum.UNDO, new UndoController(game));
		this.put(ControllerEnum.REDO, new RedoController(game));
		this.put(ControllerEnum.SAVE, new SaveController(game, FileFormat.JSON));
		this.put(ControllerEnum.EXIT_GAME, new ExitGameController(game));
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
