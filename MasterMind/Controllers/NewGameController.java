package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class NewGameController extends Controller {
	
	protected NewGameController(GameInterface game) {
		super(game);
	}

	public void newGame() {
		this.game.newGame();
		this.game.setState(State.IN_GAME);
		this.game.getCareTaker().add(this.saveToMemento());
	}
}
