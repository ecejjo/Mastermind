package MasterMind.Controllers;

import MasterMind.Model.GameStandalone;

public class LogicStandalone extends Logic {

	public LogicStandalone() {
		game = new GameStandalone();
		setMenuController(game);
	}
}
