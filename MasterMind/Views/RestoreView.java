package MasterMind.Views;

import MasterMind.Controllers.RestoreController;
import MasterMind.Util.IO;

public class RestoreView {
	
	private IO io = new IO();
	
	public void interact(RestoreController restoreController) {
		io.writeln("Restoring game ...");
		if (restoreController.restoreGameJSON()) {
			io.writeln(" - Game sucessfully restored.");
		}
		else {
			io.writeln(" - Unable to restore game.");
		}
	}
}
