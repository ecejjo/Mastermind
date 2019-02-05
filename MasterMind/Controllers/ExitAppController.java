package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class ExitAppController extends Controller {

	protected ExitAppController(GameInterface game) {
		super(game);
	}
	
	public boolean exitAppRun(char answer) {		
		if ( (answer == 's') || (answer == 'S') ) {
			this.game.setState(State.EXIT);
			return true;
		} else {
			this.game.setState(State.MENU_NOT_IN_GAME);
			return false;
		}		
	}

	public void exitApp() {
		// TODO Auto-generated method stub
		
	}	
}
