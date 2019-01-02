package MasterMind.Views;

import MasterMind.Controllers.ContinueController;
import MasterMind.Util.IO;

public class ContinueView {
	
	private IO io = new IO();
	
	public void interact(ContinueController continueController) {
		continueController.start();

		char answer;
		do {
			answer = io.readChar("Confirm to exit? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
	
		if (continueController.end(answer) == true) {
			io.writeln("Exiting ...");
			io.writeln("Bye!!");
		}
		else {
			io.writeln("Continuing ...");
		}
			
	}
}
