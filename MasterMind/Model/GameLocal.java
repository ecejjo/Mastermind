package MasterMind.Model;

import java.io.Serializable;

import MasterMind.Controllers.CareTaker;

public class GameLocal implements GameInterface, Serializable {
	
	private static final long serialVersionUID = 1L;

	private State state;
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
    
    private int tries;
	
	public static final int MAX_TRIES = 10;
	
	public CareTaker careTaker;
		
	public GameLocal() {
		this.clear();
	}
	
	public GameLocal(GameInterface game) {
		this.state = game.getState();
		this.secretCombination = new SecretCombination(game.getSecretCombination());

		this.proposedCombinations = new ProposedCombination[MAX_TRIES];
		for (int i = 0; i < game.getProposedCombinations().length; i++) {
			if (game.getProposedCombinations()[i] != null) {
				this.proposedCombinations[i] = new ProposedCombination(game.getProposedCombinations()[i]);
			}
		}
		
		this.tries = game.getTries();
	}
	
	public void copy(GameLocal game) {
		this.state = game.state;
		this.secretCombination.copy(game.secretCombination);
		
		this.proposedCombinations = new ProposedCombination[MAX_TRIES];
		for (int i = 0; i < game.proposedCombinations.length; i++) {
			if (game.proposedCombinations[i] != null) {
				this.proposedCombinations[i] = new ProposedCombination(game.proposedCombinations[i]);
			}
		}
		
		this.tries = game.tries;
	}

	public State getState() {
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public CareTaker getCareTaker() {
		return careTaker;
	}
	
	public void setCaretaker(CareTaker careTaker){
		this.careTaker = careTaker;
	}

	public void clear() {
		state = State.INITIAL;
    	secretCombination = new SecretCombination();
    	proposedCombinations = new ProposedCombination[MAX_TRIES];
    	tries = 0;
		careTaker = new CareTaker();
	}

	public boolean isWinner() {
		return proposedCombinations[tries - 1].isWinner();
	}
	
	public boolean moreTries() {
		return tries < MAX_TRIES;
	}

	public SecretCombination getSecretCombination() {
		return secretCombination;
	}
	
	public ProposedCombination[] getProposedCombinations() {
		return proposedCombinations;
	}
	
	public int getTries() {
		return tries;
	}

	public void add(ProposedCombination proposedCombination) {
		this.proposedCombinations[tries] = proposedCombination;
		tries ++;
	}

	public void calculateResult() {
		this.proposedCombinations[tries - 1].calculateResult(secretCombination);
	}
}
