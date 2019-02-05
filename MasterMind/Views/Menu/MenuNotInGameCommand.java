package MasterMind.Views.Menu;

public class MenuNotInGameCommand extends MenuCommand {

	protected void setCommands() {
		this.commandList.add(new NewGameCommand());
		this.commandList.add(new RestoreGameCommand());
		this.commandList.add(new ExitAppCommand());
	}
}
