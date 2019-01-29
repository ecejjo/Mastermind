package MasterMind.Views;

import MasterMind.Controllers.NewGameController;
import MasterMind.Util.IO;

public class NewGameView {
	
	private IO io = new IO();
	
	public void interact(NewGameController newGameController) {
		io.writeln("New game!!");
		newGameController.newGame();
	}
}
