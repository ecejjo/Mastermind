package MasterMind.Views;

import MasterMind.Controllers.UndoController;
import MasterMind.Util.IO;

public class UndoView {
	
	private IO io = new IO();
	
	public void interact(UndoController undoController) {
		io.writeln("Undoing previous try ...");
		if (undoController.undo()) {
			io.writeln(" - Undo sucesss.");
		}
		else {
			io.writeln(" - Unable to undo.");
		}
	}
}
