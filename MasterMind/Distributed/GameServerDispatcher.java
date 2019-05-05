package MasterMind.Distributed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.GameStandalone;

public abstract class GameServerDispatcher {
	
	protected GameStandalone game;
	
	protected TCPIP tcpip;
	
	protected GsonBuilder builder;
	protected Gson gson;
	
	public GameServerDispatcher(GameStandalone game, TCPIP tcpip) {
		this.game = game;
		this.tcpip = tcpip;
		
		builder = new GsonBuilder();
		gson = builder.create();
	}
	
	public abstract void dispatch();

}
