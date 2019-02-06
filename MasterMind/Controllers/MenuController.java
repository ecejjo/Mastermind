package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public abstract class MenuController extends OperationController {
	
	private NewGameController newGameController;	
	private PlayController playController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private RestoreController restoreController;
	private ExitGameController exitGameController;
	private ExitAppController exitAppController;
		
	public MenuController(GameInterface game) {
		super(game);
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
	
	public void newGame() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		newGameController.newGame();
	}
	
	public void playGame() {
		assert this.game.getState() == State.MENU_IN_GAME;
		// ? playController.
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
	
	public void restoreGame() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		restoreController.restore();
	}
	
	public void exitGame() {
		assert this.game.getState() == State.MENU_IN_GAME;
		exitGameController.exitGame();
	}
	
	public void exitApp() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		exitAppController.exitApp();
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
