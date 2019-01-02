package MasterMind.Model;

public class SecretCombination extends Combination {
	
	private static final long serialVersionUID = 1L;

	public SecretCombination() {
		super();
		this.setRandom();
	}
	
	public SecretCombination(SecretCombination secretCombination) {
		super(secretCombination);
	}
	
	public void setRandom() {
		for (int i = 0; i < COMBINATION_LENGTH; i++) {
			this.colors[i] = Color.getRandomColor();
		}
	}

	public void copy(SecretCombination secretCombination) {
		for (int i = 0; i < COMBINATION_LENGTH; i++) {
			this.colors[i] = secretCombination.colors[i];
		}		
	}
}
