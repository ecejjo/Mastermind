package MasterMind.Distributed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.GameStandalone;

public class GameServer {
	
	protected TCPIP tcpip;
	
	GameStandalone game;
		
	public GameServer() {
		this.game = new GameStandalone();
		this.tcpip = TCPIP.createServerSocket();
	}
	
	public void serve() {
		FrameType frameType = null;
		do {
			String string = this.tcpip.receiveLine();
			System.out.println("Frame received in socket: " + string);

			frameType = FrameType.parser(string);
			switch (frameType) {
			case GET_GAME:
				this.getGame();
				break;

			case SET_GAME:
				this.setGame(frameType);
				break;

			default:
				break;
			}
		} while (true);
	}
	
	private void getGame() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		this.tcpip.send(gson.toJson(this.game));
	}

	private void setGame(FrameType frameType) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jsonInString = this.tcpip.receiveLine();

		GameStandalone game = gson.fromJson(jsonInString, GameStandalone.class);
		this.game.copyGame(game);
	}
}
