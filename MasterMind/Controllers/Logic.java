package MasterMind.Controllers;

import MasterMind.Model.Game;

public class Logic {
	
	private Game game; 
	
	private StartController startController;	
	private MenuController menuController;
	private PlayController readController;
	private UndoController undoController;
	private RedoController redoController;
	private SaveController saveController;
	private RestoreController restoreController;
	private ContinueController continueController;
	
	public Logic() {
		game = new Game();
		startController = new StartController(game);
		menuController = new MenuController(game);
		readController = new PlayController(game);
		undoController = new UndoController(game);
		redoController = new RedoController(game);
		saveController = new SaveController(game);
		restoreController = new RestoreController(game);
		continueController = new ContinueController(game);
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
			
			case EXIT:
			default:
			return null;
		}
	}	
}
