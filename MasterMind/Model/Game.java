package MasterMind.Model;

import MasterMind.Util.IO;
import MasterMind.Model.State;

public class Game {
	
	private State state;
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
    private int proposedCombinationsCounter;
	
	public static final int MAX_PROPOSED_COMBINATIONS = 10;

	
	public Game() {
		this.clear();
	}
	
	public void read() {
		ProposedCombination proposedCombination = new ProposedCombination();
		this.proposedCombinations[proposedCombinationsCounter] = proposedCombination;
		this.proposedCombinations[proposedCombinationsCounter].read();
		this.proposedCombinations[proposedCombinationsCounter].calculateResult(secretCombination);
		proposedCombinationsCounter ++;		
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
    	proposedCombinations = new ProposedCombination[MAX_PROPOSED_COMBINATIONS];
    	proposedCombinationsCounter = 0;		
	}

	public boolean isWinner() {
		return proposedCombinations[proposedCombinationsCounter - 1].isWinner();
	}
	
	public boolean moreTries() {
		return proposedCombinationsCounter < MAX_PROPOSED_COMBINATIONS;
	}

	public void print() {
		IO io = new IO();		
		io.write("Secret: ");
		secretCombination.print();
		io.writeln();
		
		io.writeln("Proposed Combinations: ");
		for (int i = 0; i < proposedCombinations.length; i++) {
			if (proposedCombinations[i] != null) {
				io.write("try number " + Integer.toString(i) + " : ");
				proposedCombinations[i].print();
				io.writeln();				
			}
		}
	}
}
