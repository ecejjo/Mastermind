package MasterMind;

public class ReadController {
	
	private SecretCombination secretCombination;

	private ProposedCombination[] proposedCombinations;
	
	private int proposedCombinationsIndex;

	
	public ReadController(
			SecretCombination secretCombination,
			ProposedCombination[] proposedCombinations) {
		
		this.secretCombination = secretCombination;
		this.proposedCombinations = proposedCombinations;
		setProposedCombinationsIndex(0);
	}

	public void control() {
		ProposedCombination proposedCombination = new ProposedCombination();
		this.proposedCombinations[proposedCombinationsIndex] = proposedCombination;
		this.proposedCombinations[proposedCombinationsIndex].read();
		this.proposedCombinations[proposedCombinationsIndex].calculateResult(secretCombination);
	}

	public int getProposedCombinationsIndex() {
		return proposedCombinationsIndex;
	}

	public void setProposedCombinationsIndex(int proposedCombinationsIndex) {
		this.proposedCombinationsIndex = proposedCombinationsIndex;
	}

}
