package MasterMind.Views.Menu;

class PlayCommand extends Command {
	
	protected PlayCommand() {
		super("Play try");
	}

	@Override
	public void execute() {
		menuController.playGame();
	}
}