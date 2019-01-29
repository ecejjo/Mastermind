package MasterMind.Views.Menu;

class ExitCommand extends Command {
		
	protected ExitCommand() {
		super("Exit");
	}

	@Override
	public void execute() {
		menuController.exitGame();
	}
}