package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class UndoController extends Controller {
	
	protected UndoController(GameInterface game) {
		super(game);
	}
	
	public boolean undo() {
		this.game.setState(State.IN_GAME);
		if (game.getCareTaker().previousExists()) {
			this.restoreFromMemento(game.getCareTaker().getPrevious());
			return true;
		}
		return false;
	}
}
