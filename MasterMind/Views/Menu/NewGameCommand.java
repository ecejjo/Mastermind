package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.NewGameController;

class NewGameCommand extends Command {
	
	protected NewGameCommand() {
		super("New game");
	}

	@Override
	public void execute() {
		this.menuView.getStartView().interact((NewGameController) menuController.getController(ControllerEnum.NEW_GAME));
	}
}