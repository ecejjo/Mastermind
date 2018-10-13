package Views;

import MasterMind.Controllers.OperationController;
import MasterMind.Util.IO;

public class GameView {
	
	private OperationController controller;

	public GameView(OperationController controller) {
			assert controller != null;
			this.controller = controller;
	}

	public void print() {
		IO io = new IO();		
		io.write("Secret: ");
		new SecretCombinationView(controller.getSecretCombination()).print();
		io.writeln();
		
		io.writeln("Proposed Combinations: ");
		for (int i = 0; i < controller.getProposedCombinations().length; i++) {
			if (controller.getProposedCombinations()[i] != null) {
				io.write("try number " + Integer.toString(i) + " : ");
				new ProposedCombinationView(controller.getProposedCombinations()[i]).print();
				io.writeln();				
			}
		}
	}
}
