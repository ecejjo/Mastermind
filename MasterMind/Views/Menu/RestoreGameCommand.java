package MasterMind.Views.Menu;

class RestoreGameCommand extends Command {
	
	protected RestoreGameCommand() {
		super("Restore game");
	}

	@Override
	public void execute() {
		menuController.restoreGame();
	}
}