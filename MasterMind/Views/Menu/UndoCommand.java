package MasterMind.Views.Menu;

class UndoCommand extends Command {
	
	protected UndoCommand() {
		super("Undo try");
	}

	@Override
	public void execute() {
		this.menuView.getUndoView().interact(menuController.getUndoController());
		menuController.undo();
	}
}