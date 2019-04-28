package MasterMind.Views.Menu;

import MasterMind.Controllers.NewGameController;
import MasterMind.Model.State;

class NewGameCommand extends Command {
	
	protected NewGameCommand() {
		super("New game");
	}

	@Override
	public void execute() {
		this.menuView.getStartView().interact((NewGameController) menuController.getController(State.NEW_GAME));
	}
}