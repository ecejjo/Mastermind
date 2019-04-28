package MasterMind.Views.Menu;

import MasterMind.Controllers.ExitAppController;
import MasterMind.Model.State;

class ExitAppCommand extends Command {
		
	protected ExitAppCommand() {
		super("Exit App");
	}

	@Override
	public void execute() {
		this.menuView.getExitAppView().interact((ExitAppController) menuController.getController(State.EXIT_APP));
	}
}