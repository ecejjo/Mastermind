package MasterMind.Views.Menu;

import MasterMind.Controllers.UndoController;
import MasterMind.Model.State;

class UndoCommand extends Command {
	
	protected UndoCommand() {
		super("Undo try");
	}

	@Override
	public void execute() {
		this.menuView.getUndoView().interact((UndoController) menuController.getController(State.UNDO));
	}
}