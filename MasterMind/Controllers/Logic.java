package MasterMind.Controllers;

import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;

public class Logic {

	private GameInterface game;
	private MenuController menuController;

	public Logic() {
		game = new GameLocal();
		menuController = new MenuController(game);
		menuController.put(ControllerEnum.MENU_IN_GAME, new MenuInGameController(game));
		menuController.put(ControllerEnum.MENU_NOT_IN_GAME, new MenuNotInGameController(game));
	}

	public OperationController getController() {
		return (OperationController) menuController.getController(game.getState());
	}
}
