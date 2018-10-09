package MasterMind;

public class ProposedCombination extends Combination {
		
	private Result result;
	
	public ProposedCombination () {
		super();
		result = new Result();
	}

	public void read() {
		for (int i = 0; i < colors.length; i++) {
			// colors.get(i).readColor();
			colors[i] = LimitedCharDialog.readColor();			
		}
	}
	
	public void calculateResult(Combination secretCombination) {
				
		Combination auxSecretCombination = new Combination();
		auxSecretCombination = secretCombination.copy();
		Color[] thisColors = this.copy().colors;
								
		for (int i = 0; i < colors.length; i++) {
			if (thisColors[i].toInt() == auxSecretCombination.colors[i].toInt()) {
				this.result.add(Success.BLACK);
				thisColors[i] = Color.NONE;
				auxSecretCombination.colors[i] = Color.NONE;
			}
		}
				
		for (int i = 0; i < colors.length; i++) {
			if (thisColors[i] == Color.NONE) {
				continue;
			}
			if (thisColors[i].isIncluded(auxSecretCombination.getColors())) {
				this.result.add(Success.WHITE);
			}
		}
	}

	public void print() {
		super.print();
		result.print();
	}

	public boolean isWinner() {
		return result.isWinner();
	}
}
