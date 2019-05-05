package MasterMind.Distributed;

import MasterMind.Model.GameStandalone;

public class SetGameDispatcher extends GameServerDispatcher {

	public SetGameDispatcher(GameStandalone game, TCPIP tcpip) {
		super(game, tcpip);
	}

	@Override
	public void dispatch() {
		String jsonInString = this.tcpip.receiveLine();
		GameStandalone game = gson.fromJson(jsonInString, GameStandalone.class);
		this.game.copyGame(game);
	}

}
