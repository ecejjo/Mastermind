package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.UndoController;

class UndoCommand extends Command {
	
	protected UndoCommand() {
		super("Undo try");
	}

	@Override
	public void execute() {
		this.menuView.getUndoView().interact((UndoController) menuController.getController(ControllerEnum.UNDO));
	}
}