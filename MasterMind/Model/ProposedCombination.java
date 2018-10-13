package MasterMind.Model;

import MasterMind.Util.LimitedCharDialog;

public class ProposedCombination extends Combination {
		
	private Result result;
	
	public ProposedCombination () {
		super();
		result = new Result();
	}
	
	public void calculateResult(Combination secretCombination) {
				
		Combination auxSecretCombination = new Combination();
		auxSecretCombination = secretCombination.copy();
		Color[] thisColors = this.copy().colors;
								
		for (int i = 0; i < colors.length; i++) {
			if (thisColors[i].toInt() == auxSecretCombination.colors[i].toInt()) {
				this.getResult().add(Success.BLACK);
				thisColors[i] = Color.NONE;
				auxSecretCombination.colors[i] = Color.NONE;
			}
		}
				
		for (int i = 0; i < colors.length; i++) {
			if (thisColors[i] == Color.NONE) {
				continue;
			}
			if (thisColors[i].isIncluded(auxSecretCombination.getColors())) {
				this.getResult().add(Success.WHITE);
			}
		}
	}

	public boolean isWinner() {
		return getResult().isWinner();
	}

	public Result getResult() {
		return result;
	}
}
