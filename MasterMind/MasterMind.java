package MasterMind;

public class MasterMind {
	
	private SecretCombination secretCombination;
	
    private ProposedCombination[] proposedCombinations;
	
	public static final int MAX_PROPOSED_COMBINATIONS = 10;
	
	private ReadController readController;
                
    public MasterMind() {
    	secretCombination = new SecretCombination();
    	proposedCombinations = new ProposedCombination[MAX_PROPOSED_COMBINATIONS];
    	readController = new ReadController(secretCombination, proposedCombinations);
    }
    
    public void play() {
		int current = 0;
    	do
    	{
    		this.print();
    		readController.setProposedCombinationsIndex(current);
    		readController.control();    		
    		current ++;
    	}
    	while ( ! proposedCombinations[current - 1].isWinner() && current < MAX_PROPOSED_COMBINATIONS);
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
    
    public static void main(String[] args) {
        new MasterMind().play();
    }
}
