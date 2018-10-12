package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;

public class StartController extends Controller {
	
	protected StartController(Game game) {
		super(game);
	}

	public void control() {
		assert this.getState() == State.INITIAL;
		this.print();
		this.setState(State.PLAYING);
	}
}
