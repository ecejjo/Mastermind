package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.PlayController;

class PlayCommand extends Command {
	
	protected PlayCommand() {
		super("Play try");
	}

	@Override
	public void execute() {
		this.menuView.getPlayView().interact((PlayController) menuController.getController(ControllerEnum.PLAY));
	}
}