package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;
import MasterMind.Util.IO;

public class ContinueController extends Controller {

	protected ContinueController(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void control() {
		assert this.getState() == State.FINAL;
		
		IO io = new IO();
		char answer;
		do {
			answer = io.readChar("Play again? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
		if (answer == 's') {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}		
	}
}
