package MasterMind.Distributed;

import MasterMind.Model.GameStandalone;

public class GameServerSetGame extends GameServerDispatcher {

	public GameServerSetGame(GameStandalone game, TCPIP tcpip) {
		super(game, tcpip);
	}

	@Override
	public void dispatch() {
		String jsonInString = this.tcpip.receiveLine();
		GameStandalone game = gson.fromJson(jsonInString, GameStandalone.class);
		this.game.copyGame(game);
	}

}
