package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public abstract class Logic {

	protected GameInterface game;
	private MenuController menuController;

	public void setMenuController(GameInterface game) {
		menuController = new MenuController(game);
		menuController.put(ControllerEnum.MENU_IN_GAME, new MenuInGameController(game));
		menuController.put(ControllerEnum.MENU_NOT_IN_GAME, new MenuNotInGameController(game));
	}

	public OperationController getController() {
		return (OperationController) menuController.getController(game.getState());
	}
}
