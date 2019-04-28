package MasterMind.Views.Menu;

import MasterMind.Controllers.RedoController;
import MasterMind.Model.State;

class RedoCommand extends Command {
	
	protected RedoCommand() {
		super("Redo try");
	}

	@Override
	public void execute() {
		this.menuView.getRedoView().interact((RedoController) menuController.getController(State.REDO));
	}
}