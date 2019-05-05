package MasterMind.Distributed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Controllers.CareTaker;
import MasterMind.Model.GameInterface;
import MasterMind.Model.GameStandalone;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.SecretCombination;
import MasterMind.Model.State;

public class GameClient implements GameInterface {

	protected TCPIP tcpip;
	
	GameStandalone game;
				
	public GameClient() {
		game = new GameStandalone();
		this.tcpip = TCPIP.createClientSocket();
		this.setRemoteGame();
	}
	
	private void getRemoteGame() {
		if (this.tcpip != null)
		{
			this.tcpip.send(FrameType.GET_GAME.name());

			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String jsonInString = this.tcpip.receiveLine();

			GameStandalone game = gson.fromJson(jsonInString, GameStandalone.class);
			this.game.copyGame(game);
		}
	}
	
	private void setRemoteGame() {
		if (this.tcpip != null)
		{
			this.tcpip.send(FrameType.SET_GAME.name());
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			this.tcpip.send(gson.toJson(game));
		}
	}
	
	public State getState() {
		this.getRemoteGame();
		return this.game.getState();
	}

	public void setState(State state) {
		game.setState(state);
		this.setRemoteGame();
		
		if (state == State.EXIT) {
			this.tcpip.send(FrameType.EXIT.name());
			this.tcpip.close();
			this.tcpip = null;
		}
	}
	
	public CareTaker getCareTaker() {
		this.getRemoteGame();
		return this.game.careTaker;
	}
	
	public void setCaretaker(CareTaker careTaker){
		game.setCaretaker(careTaker);
		this.setRemoteGame();
	}

	public void newGame() {
		game.newGame();
		this.setRemoteGame();
	}
	
	public void clear() {
		game.clear();
		this.setRemoteGame();
	}
	
	public void exitGame() {
		game.exitGame();
		this.setRemoteGame();
	}
	
	public boolean isWinner() {
		this.getRemoteGame();
		return this.game.isWinner();
	}
	
	public boolean moreTries() {
		this.getRemoteGame();
		return this.game.moreTries();
	}

	public SecretCombination getSecretCombination() {
		this.getRemoteGame();
		return this.game.getSecretCombination();
	}
	
	public ProposedCombination[] getProposedCombinations() {
		this.getRemoteGame();
		return this.game.getProposedCombinations();
	}
	
	public int getTries() {
		this.getRemoteGame();
		return this.game.getTries();
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.game.addProposedCombination(proposedCombination);
		this.setRemoteGame();
	}

	public void calculateResult() {
		game.calculateResult();
		this.setRemoteGame();
	}
	
	public boolean inGame() {
		this.getRemoteGame();
		return this.game.inGame();
	}

	public void copyGame(GameStandalone savedState) {
		game.copyGame(savedState);
		this.setRemoteGame();
	}

	@Override
	public GameInterface data() {
		return this.game;
	}
}
