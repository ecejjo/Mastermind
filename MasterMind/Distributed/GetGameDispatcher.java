package MasterMind.Distributed;

import MasterMind.Model.GameStandalone;

public class GetGameDispatcher extends GameServerDispatcher {

	public GetGameDispatcher(GameStandalone game, TCPIP tcpip) {
		super(game, tcpip);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(gson.toJson(this.game));		
	}

}
