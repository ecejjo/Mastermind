package MasterMind.Distributed;

import MasterMind.Model.GameStandalone;

public class ExitGameDispatcher extends GameServerDispatcher {

	public ExitGameDispatcher(GameStandalone game, TCPIP tcpip) {
		super(game, tcpip);
	}

	@Override
	public void dispatch() {
		// Nothing to do.
	}

}
