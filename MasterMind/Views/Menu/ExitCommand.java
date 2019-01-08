package MasterMind.Views.Menu;

class ExitCommand extends Command {
	
	private boolean closed;
	
	protected ExitCommand() {
		super("Exit Game");
	}

	@Override
	public void execute() {
		menuController.exitGame();
		closed = true;
	}

	public boolean closed() {
		return closed;
	}
	
	public void reset() {
		closed = false;
	}
}