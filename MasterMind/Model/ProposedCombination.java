package MasterMind.Model;

public class ProposedCombination extends Combination {
		
	private Result result;
	
	public ProposedCombination () {
		super();
		result = new Result();
	}
	
	public void calculateResult(Combination secretCombination) {
				
		this.getResult().clear();
		
		Combination auxSecretCombination = new Combination(secretCombination);
		Combination auxThisCombination = new Combination(this);
								
		for (int i = 0; i < colors.length; i++) {
			if (auxThisCombination.colors[i].getValue() == auxSecretCombination.colors[i].getValue()) {
				this.getResult().add(Success.BLACK);
				auxThisCombination.colors[i] = Color.NONE;
				auxSecretCombination.colors[i] = Color.NONE;
			}
		}
				
		for (int i = 0; i < colors.length; i++) {
			if (auxThisCombination.colors[i] == Color.NONE) {
				continue;
			}
			if (auxThisCombination.colors[i].isIncluded(auxSecretCombination.getColors())) {
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
