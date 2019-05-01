package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.ExitAppController;

class ExitAppCommand extends Command {
		
	protected ExitAppCommand() {
		super("Exit App");
	}

	@Override
	public void execute() {
		this.menuView.getExitAppView().interact((ExitAppController) menuController.getController(ControllerEnum.EXIT_APP));
	}
}