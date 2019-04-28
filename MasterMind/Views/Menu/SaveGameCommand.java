package MasterMind.Views.Menu;

import MasterMind.Controllers.SaveController;
import MasterMind.Model.State;

class SaveGameCommand extends Command {
	
	protected SaveGameCommand() {
		super("Save game");
	}

	@Override
	public void execute() {
		this.menuView.getSaveView().interact((SaveController) menuController.getController(State.SAVE));
	}
}