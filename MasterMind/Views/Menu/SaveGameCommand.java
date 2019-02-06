package MasterMind.Views.Menu;

class SaveGameCommand extends Command {
	
	protected SaveGameCommand() {
		super("Save game");
	}

	@Override
	public void execute() {
		this.menuView.getSaveView().interact(menuController.getSaveController());
	}
}