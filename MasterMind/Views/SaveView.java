package MasterMind.Views;

import MasterMind.Controllers.SaveController;
import MasterMind.Util.IO;

public class SaveView {
	
	private IO io = new IO();
	
	public void interact(SaveController saveController) {
		io.writeln("Saving game ...");
		if (saveController.save()) {
			io.writeln(" - Game sucessfully saved.");
		}
		else {
			io.writeln(" - Unable to save game.");
		}
	}
}
