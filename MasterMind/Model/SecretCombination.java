package MasterMind.Model;

public class SecretCombination extends Combination {
	
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
}
