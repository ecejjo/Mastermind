package MasterMind.Views.Menu;

import MasterMind.Controllers.RestoreController;
import MasterMind.Model.State;

class RestoreGameCommand extends Command {
	
	protected RestoreGameCommand() {
		super("Restore game");
	}

	@Override
	public void execute() {
		this.menuView.getRestoreView().interact((RestoreController) menuController.getController(State.RESTORE));
	}
}