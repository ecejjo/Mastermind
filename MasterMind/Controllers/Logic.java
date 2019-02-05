package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;

public class Logic {

	private GameInterface game; 
	private MenuNotInGameController menuNotInGameController;
	private MenuInGameController menuInGameController;
	
	public Logic() {
		game = new GameLocal();
		menuNotInGameController = new MenuNotInGameController(game);
		menuInGameController = new MenuInGameController(game);
	}

	public OperationController getController() {
		switch (game.getState()) {
		
			case MENU_NOT_IN_GAME:
			return menuNotInGameController;

			case MENU_IN_GAME:
			return menuInGameController;

			case EXIT:
			default:
			return null;
		}
	}	
}
