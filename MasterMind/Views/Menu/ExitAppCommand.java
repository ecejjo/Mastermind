package MasterMind.Views.Menu;

class ExitAppCommand extends Command {
		
	protected ExitAppCommand() {
		super("Exit App");
	}

	@Override
	public void execute() {
		this.menuView.getExitAppView().interact(menuController.getExitAppController());
		menuController.exitApp();
	}
}