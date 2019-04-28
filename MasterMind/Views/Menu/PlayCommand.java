package MasterMind.Views.Menu;

import MasterMind.Controllers.PlayController;
import MasterMind.Model.State;

class PlayCommand extends Command {
	
	protected PlayCommand() {
		super("Play try");
	}

	@Override
	public void execute() {
		this.menuView.getPlayView().interact((PlayController) menuController.getController(State.PLAY));
	}
}