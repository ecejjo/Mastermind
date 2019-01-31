package MasterMind.Views.Menu;

class ExitAppCommand extends Command {
		
	protected ExitAppCommand() {
		super("Exit App");
	}

	@Override
	public void execute() {
		menuController.exitApp();
	}
}