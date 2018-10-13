package MasterMind.Model;

public class Game {
	
	private State state;
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
    private int tries;
	
	public static final int MAX_TRIES = 10;

	
	public Game() {
		this.clear();
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

}
