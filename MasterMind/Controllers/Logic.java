package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class Logic {

	private GameInterface game;
	private MenuController menuController;

	public Logic() {
		game = new GameLocal();
		menuController = new MenuController(game);
		menuController.addController(State.MENU_IN_GAME, new MenuInGameController(game));
		menuController.addController(State.MENU_NOT_IN_GAME, new MenuNotInGameController(game));
		menuController.addController(State.EXIT, null);
	}

	public OperationController getController() {
		return (OperationController) menuController.getController(game.getState());
	}
}
