package MasterMind.Views.Menu;

public class MenuInGameCommand extends MenuCommand {

	protected void setCommands() {

		if (this.menuController.moreTries() &
				! this.menuController.isWinner() ) {
			this.commandList.add(new PlayCommand());
		}

		if (this.menuController.isUndoable()) {
			this.commandList.add(new UndoCommand());			
		}

		if (this.menuController.isRedoable()) {
			this.commandList.add(new RedoCommand());			
		}

		this.commandList.add(new SaveGameCommand());	
		this.commandList.add(new ExitGameCommand());		
	}
}
