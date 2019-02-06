package MasterMind.Views.Menu;

class ExitGameCommand extends Command {
	
	protected ExitGameCommand() {
		super("Exit game");
	}

	@Override
	public void execute() {
		this.menuView.getExitGameView().interact(menuController.getExitGameController());
	}
}