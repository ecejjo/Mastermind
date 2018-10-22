package MasterMind.Views;

import MasterMind.Controllers.StartController;
import MasterMind.Util.IO;

public class StartView {
	
	private IO io = new IO();
	
	public void interact(StartController startController) {
		io.writeln("Game starts!!");
		startController.start();
	}
}
