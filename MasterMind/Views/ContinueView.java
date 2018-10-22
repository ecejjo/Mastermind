package MasterMind.Views;

import MasterMind.Controllers.ContinueController;
import MasterMind.Util.IO;

public class ContinueView {
	
	private IO io = new IO();
	
	public void interact(ContinueController continueController) {
		continueController.start();

		char answer;
		do {
			answer = io.readChar("Play again? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
		
		continueController.end(answer);
	}
}
