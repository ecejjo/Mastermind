package MasterMind.Views.Menu;

import MasterMind.Controllers.ControllerEnum;
import MasterMind.Controllers.SaveController;

class SaveGameCommand extends Command {
	
	protected SaveGameCommand() {
		super("Save game");
	}

	@Override
	public void execute() {
		this.menuView.getSaveView().interact((SaveController) menuController.getController(ControllerEnum.SAVE));
	}
}