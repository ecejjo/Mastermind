package MasterMind.Distributed;

import MasterMind.Model.GameStandalone;

public class GameServerExitGame extends GameServerDispatcher {

	public GameServerExitGame(GameStandalone game, TCPIP tcpip) {
		super(game, tcpip);
	}

	@Override
	public void dispatch() {
		// Nothing to do.
	}

}
