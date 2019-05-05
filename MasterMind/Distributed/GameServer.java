package MasterMind.Distributed;

import java.util.HashMap;
import java.util.Map;

import MasterMind.Model.GameStandalone;

public class GameServer {
	
	protected TCPIP tcpip;
	
	GameStandalone game;
	
	private Map<FrameType, GameServerDispatcher> gameServerDispatchersMap;
		
	public GameServer() {
		this.game = new GameStandalone();
		this.tcpip = TCPIP.createServerSocket();
		
		this.gameServerDispatchersMap = new HashMap<FrameType, GameServerDispatcher>();
		this.gameServerDispatchersMap.put(FrameType.GET_GAME, new GameServerGetGame(this.game, this.tcpip));
		this.gameServerDispatchersMap.put(FrameType.SET_GAME, new GameServerSetGame(this.game, this.tcpip));
		this.gameServerDispatchersMap.put(FrameType.EXIT, new GameServerExitGame(this.game, this.tcpip));
	}
	
	public void serve() {
		FrameType frameType = null;
		do {
			String recvedLine = this.tcpip.receiveLine();
			System.out.println("Frame received in socket: " + recvedLine);
			frameType = FrameType.parser(recvedLine);
			this.gameServerDispatchersMap.get(frameType).dispatch();
		} while (frameType != FrameType.EXIT);
		this.tcpip.close();
	}	
}
