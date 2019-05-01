package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.RestoreController;

class RestoreGameCommand extends Command {
	
	protected RestoreGameCommand() {
		super("Restore game");
	}

	@Override
	public void execute() {
		this.menuView.getRestoreView().interact((RestoreController) menuController.getController(ControllerEnum.RESTORE));
	}
}