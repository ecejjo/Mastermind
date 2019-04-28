package MasterMind.Views.Menu;

import MasterMind.Controllers.ExitGameController;
import MasterMind.Model.State;

class ExitGameCommand extends Command {
	
	protected ExitGameCommand() {
		super("Exit game");
	}

	@Override
	public void execute() {
		this.menuView.getExitGameView().interact((ExitGameController) menuController.getController(State.EXIT_GAME));
	}
}