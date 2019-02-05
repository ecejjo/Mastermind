package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ExitGameController extends Controller {

	protected ExitGameController(GameInterface game) {
		super(game);
	}
		
	public boolean exitGameRun(char answer) {		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.exitGame();
			return true;
		} else {
			this.game.setState(State.MENU_IN_GAME);
			return false;
		}		
	}

	public void exitGame() {
		// TODO Auto-generated method stub
		
	}
}