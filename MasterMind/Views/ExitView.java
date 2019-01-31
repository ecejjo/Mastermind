package MasterMind.Views;

import MasterMind.Controllers.ExitController;
import MasterMind.Util.IO;

public class ExitView {
	
	private IO io = new IO();
	
	public void interact(ExitController controller) {

		char answer;
		
		do {
			answer = io.readChar("Confirm to exit? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
	
		if (controller.exitRun(answer) == true) {
			io.writeln("Exiting ...");
			io.writeln("Bye!!");
		}
		else {
			io.writeln("Continuing ...");
		}
			
	}
}
