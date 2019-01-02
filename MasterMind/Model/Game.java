package MasterMind.Model;

import java.io.Serializable;

import MasterMind.Controllers.CareTaker;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private State state;
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
    
    private int tries;
	
	public static final int MAX_TRIES = 10;
	
	public CareTaker careTaker;
		
	public Game() {
		this.clear();
	}
	
	public Game(Game game) {
		this.state = game.state;
		this.secretCombination = new SecretCombination(game.secretCombination);

		this.proposedCombinations = new ProposedCombination[MAX_TRIES];
		for (int i = 0; i < game.proposedCombinations.length; i++) {
			if (game.proposedCombinations[i] != null) {
				this.proposedCombinations[i] = new ProposedCombination(game.proposedCombinations[i]);
			}
		}
		
		this.tries = game.tries;
	}
	
	public void copy(Game game) {
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

	public void add(ProposedCombination proposedCombination) {
		this.proposedCombinations[tries] = proposedCombination;
		tries ++;
	}

	public void calculateResult() {
		this.proposedCombinations[tries - 1].calculateResult(secretCombination);
	}
}
