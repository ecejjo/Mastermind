package MasterMind.Views;

import MasterMind.Model.Color;
import MasterMind.Model.ProposedCombination;
import MasterMind.Util.IO;

public class ProposedCombinationView {
	
	ProposedCombination proposedCombination;
	
	public ProposedCombinationView() {
		proposedCombination = new ProposedCombination(); 
	}

	public ProposedCombinationView(ProposedCombination proposedCombination) {
		this.proposedCombination = proposedCombination;
	}
	
	public ProposedCombination read() {
		
		proposedCombination = new ProposedCombination();
		
		Color[] colors = proposedCombination.getColors();
		for (int i = 0; i < colors.length; i++) {
			colors[i] = new ColorView().readColor();	
		}
		
		proposedCombination.setColors(colors);
		return proposedCombination;
	}


	public void print() {
		for (int i = 0; i < proposedCombination.getColors().length; i++) {
			new ColorView(proposedCombination.getColors()[i]).print();
		}
		
		IO io = new IO();
		io.write(" - Result: ");
		new ResultView(proposedCombination.getResult()).print();
	}
}
