package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.RedoController;

class RedoCommand extends Command {
	
	protected RedoCommand() {
		super("Redo try");
	}

	@Override
	public void execute() {
		this.menuView.getRedoView().interact((RedoController) menuController.getController(ControllerEnum.REDO));
	}
}