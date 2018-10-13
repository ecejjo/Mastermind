package MasterMind.Model;

import MasterMind.Util.IO;
import MasterMind.Model.State;

public class Game {
	
	private State state;
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
    private int tries;
	
	public static final int MAX_TRIES = 10;

	
	public Game() {
		this.clear();
	}
	
	public void read() {
		ProposedCombination proposedCombination = new ProposedCombination();
		this.proposedCombinations[tries] = proposedCombination;
		this.proposedCombinations[tries].read();
		this.proposedCombinations[tries].calculateResult(secretCombination);
		tries ++;		
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
	}

	public boolean isWinner() {
		return proposedCombinations[tries - 1].isWinner();
	}
	
	public boolean moreTries() {
		return tries < MAX_TRIES;
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
