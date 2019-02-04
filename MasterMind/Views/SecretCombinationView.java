package MasterMind.Views;

import MasterMind.Model.SecretCombination;

public class SecretCombinationView {
	
	SecretCombination secretCombination;

	public SecretCombinationView(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
	}

	public void print() {
		if (this.secretCombination != null)
		{
			for (int i = 0; i < secretCombination.getColors().length; i++) {
				new ColorView(secretCombination.getColors()[i]).print();
			}
		}
	}
}
