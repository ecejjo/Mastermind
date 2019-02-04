package MasterMind.Views.Menu;

class NewGameCommand extends Command {
	
	protected NewGameCommand() {
		super("New game");
	}

	@Override
	public void execute() {
		this.menuView.getStartView().interact(menuController.getNewGameController());
		menuController.newGame();
	}
}