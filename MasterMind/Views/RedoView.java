package MasterMind.Views;

import MasterMind.Controllers.RedoController;
import MasterMind.Util.IO;

public class RedoView {
	
	private IO io = new IO();
	
	public void interact(RedoController redoController) {
		io.writeln("Redoing previous try ...");
		if (redoController.run()) {
			io.writeln(" - Redo sucesss.");
		}
		else {
			io.writeln(" - Unable to redo.");
		}
	}
}
