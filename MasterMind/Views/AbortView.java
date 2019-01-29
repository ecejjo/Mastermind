package MasterMind.Views;

import MasterMind.Controllers.AbortController;
import MasterMind.Util.IO;

public class AbortView {
	
	private IO io = new IO();
	
	public void interact(AbortController abortController) {

		char answer;
		
		if (abortController.moreTries() == false) {
			answer = 's';
		}
		else {	
			do {
				answer = io.readChar("Confirm to abort game? (s/n): ");
			} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
		}
	
		if (abortController.abort(answer) == true) {
			io.writeln("Game aborted.");
		}
		else {
			io.writeln("Game continues ...");
		}
			
	}
}
