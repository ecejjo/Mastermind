package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;

public class Logic {
	
	private GameInterface game; 
	
	private StartController startController;	
	private MenuController menuController;
	private PlayController readController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private RestoreController restoreController;
	private ContinueController continueController;
	private AbortController abortController;
	
	public Logic() {
		game = new GameLocal();
		startController = new StartController(game);
		menuController = new MenuController(game);
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
			case INITIAL:
			return startController;
			
			case MENU:
			return menuController;
			
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
