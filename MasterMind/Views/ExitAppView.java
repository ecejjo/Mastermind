package MasterMind.Views;

import MasterMind.Controllers.ExitAppController;
import MasterMind.Util.IO;

public class ExitAppView {
	
	private IO io = new IO();
	
	public void interact(ExitAppController controller) {

		char answer;
		
		do {
			answer = io.readChar("Confirm to exit application? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
	
		if (controller.exitAppRun(answer) == true) {
			io.writeln("Application exits ...");
			io.writeln("Bye!!");
		}
		else {
			io.writeln("Application continues ...");
		}
			
	}
}
