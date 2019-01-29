package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;

public class Logic {
	
	private GameInterface game; 
	
	private MenuController menuController;
	private NewGameController newGameController;	
	private PlayController readController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private RestoreController restoreController;
	private ContinueController continueController;
	private AbortController abortController;
	
	public Logic() {
		game = new GameLocal();
		menuController = new MenuController(game);
		newGameController = new NewGameController(game);
		readController = new PlayController(game);
		undoController = new UndoController(game);
		redoController = new RedoController(game);
		saveController = new SaveController(game, "JSON");
		restoreController = new RestoreController(game, "JSON");
		continueController = new ContinueController(game);
		abortController = new AbortController(game);
	}

	public OperationController getController() {
		switch (game.getState()) {
			case MENU:
			return menuController;

			case NEW_GAME:
			return newGameController;
			
			case PLAYING:
			return readController;

			case UNDOING:
			return undoController;

			case REDOING:
			return redoController;
			
			case SAVING:
			return saveController;

			case RESTORING:
			return restoreController;

			case CONTINUE:
			return continueController;
			
			case ABORT:
			return abortController;
			
			case EXIT:
			default:
			return null;
		}
	}	
}
