package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;

public class Logic {
	
	private GameInterface game; 
	
	private MenuController menuController;
	private NewGameController newGameController;	
	private PlayController playController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private RestoreController restoreController;
	private ExitGameController exitGameController;
	private ExitAppController exitAppController;
	
	public Logic() {
		game = new GameLocal();
		menuController = new MenuController(game);
		newGameController = new NewGameController(game);
		playController = new PlayController(game);
		undoController = new UndoController(game);
		redoController = new RedoController(game);
		saveController = new SaveController(game, "JSON");
		restoreController = new RestoreController(game, "JSON");
		exitAppController = new ExitAppController(game);
		exitGameController = new ExitGameController(game);
		
		menuController.setNewGameController(newGameController);
		menuController.setPlayController(playController);
		menuController.setUndoController(undoController);
		menuController.setRedoController(redoController);
		menuController.setSaveController(saveController);
		menuController.setRestoreController(restoreController);
		menuController.setExitAppController(exitAppController);
		menuController.setExitGameController(exitGameController);
	}

	public OperationController getController() {
		switch (game.getState()) {
			case MENU:
			return menuController;

			case EXIT:
			default:
			return null;
		}
	}	
}
