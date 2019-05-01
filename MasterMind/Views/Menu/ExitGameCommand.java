package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.ExitGameController;

class ExitGameCommand extends Command {
	
	protected ExitGameCommand() {
		super("Exit game");
	}

	@Override
	public void execute() {
		this.menuView.getExitGameView().interact((ExitGameController) menuController.getController(ControllerEnum.EXIT_GAME));
	}
}