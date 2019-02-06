package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public abstract class MenuController extends OperationController {
	
	protected NewGameController newGameController;	
	protected PlayController playController;
	protected UndoController undoController;
	protected RedoController redoController;
	protected SaveController saveController;
	protected RestoreController restoreController;
	protected ExitGameController exitGameController;
	protected ExitAppController exitAppController;

	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}
		
	public MenuController(GameInterface game) {
		super(game);
	}

	public NewGameController getNewGameController() {
		return newGameController;
	}

	public void setNewGameController(NewGameController newGameController) {
		this.newGameController = newGameController;
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

	public RestoreController getRestoreController() {
		return restoreController;
	}

	public void setRestoreController(RestoreController restoreController) {
		this.restoreController = restoreController;
	}

	public ExitGameController getExitGameController() {
		return exitGameController;
	}

	public void setExitGameController(ExitGameController exitGameController) {
		this.exitGameController = exitGameController;
	}

	public ExitAppController getExitAppController() {
		return exitAppController;
	}

	public void setExitAppController(ExitAppController exitAppController) {
		this.exitAppController = exitAppController;
	}
}
