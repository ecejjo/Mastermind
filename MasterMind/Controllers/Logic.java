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
	private ExitController exitController;
	private AbortController abortController;
	
	public Logic() {
		game = new GameLocal();
		menuController = new MenuController(game);
		newGameController = new NewGameController(game);
		playController = new PlayController(game);
		undoController = new UndoController(game);
		redoController = new RedoController(game);
		saveController = new SaveController(game, "JSON");
		restoreController = new RestoreController(game, "JSON");
		exitController = new ExitController(game);
		abortController = new AbortController(game);
		
		menuController.add(newGameController);
		menuController.add(playController);
		menuController.add(undoController);
		menuController.add(redoController);
		menuController.add(saveController);
		menuController.add(restoreController);
		menuController.add(exitController);
		menuController.add(abortController);
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
