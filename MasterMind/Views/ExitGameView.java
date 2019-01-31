package MasterMind.Views;

import MasterMind.Controllers.ExitGameController;
import MasterMind.Util.IO;

public class ExitGameView {
	
	private IO io = new IO();
	
	public void interact(ExitGameController controller) {

		char answer;

		do {
			answer = io.readChar("Confirm to exit game? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');

		if (controller.exitGameRun(answer) == true) {
			io.writeln("Game exits ...");
		}
		else {
			io.writeln("Game continues ...");
		}
	}
}
