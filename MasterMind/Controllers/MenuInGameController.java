package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuInGameController extends MenuController {
	
	private PlayController playController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private ExitGameController exitGameController;
		
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
				
	public boolean inGame() {
		return this.game.getState() == State.MENU_IN_GAME;
	}
	
	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}

	public void undo() {
		assert this.game.getState() == State.MENU_IN_GAME;
		undoController.undo();
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public void redo() {
		assert this.game.getState() == State.MENU_IN_GAME;
		redoController.redo();
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}

	public void saveGame() {
		assert this.game.getState() == State.MENU_IN_GAME;
		saveController.saveGame();
	}
	
	public void exitGame() {
		assert this.game.getState() == State.MENU_IN_GAME;
		exitGameController.exitGame();
	}
	
	public PlayController getPlayController() {
		return playController;
	}

	public void setPlayController(PlayController playController) {
		this.playController = playController;
	}

	public UndoController getUndoController() {
		return undoController;
	}

	public void setUndoController(UndoController undoController) {
		this.undoController = undoController;
	}

	public RedoController getRedoController() {
		return redoController;
	}

	public void setRedoController(RedoController redoController) {
		this.redoController = redoController;
	}

	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
	}

	public ExitGameController getExitGameController() {
		return exitGameController;
	}

	public void setExitGameController(ExitGameController exitGameController) {
		this.exitGameController = exitGameController;
	}
}
