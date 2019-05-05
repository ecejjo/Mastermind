package MasterMind.Distributed;

import MasterMind.Controllers.Logic;

public class LogicClient extends Logic {

	public LogicClient() {
		game = new GameClient();
		setMenuController(game);
	}
}
