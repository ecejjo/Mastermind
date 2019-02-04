package MasterMind.Views.Menu;

class RedoCommand extends Command {
	
	protected RedoCommand() {
		super("Redo try");
	}

	@Override
	public void execute() {
		this.menuView.getRedoView().interact(menuController.getRedoController());
		menuController.redo();
	}
}