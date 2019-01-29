package MasterMind.Views.Menu;

class AbortGameCommand extends Command {
	
	protected AbortGameCommand() {
		super("Abort game");
	}

	@Override
	public void execute() {
		menuController.abortGame();
	}
}