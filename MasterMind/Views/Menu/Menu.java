package MasterMind.Views.Menu;

import java.util.ArrayList;
import java.util.List;

import MasterMind.Controllers.MenuController;
import MasterMind.Util.IO;
import MasterMind.Util.LimitedIntDialog;

public class Menu {

	protected List<Command> commandList;

	private ExitCommand exitCommand;
	
	private MenuController menuController;

	public Menu() {
		this.commandList = new ArrayList<Command>();
		exitCommand = new ExitCommand();
	}

	protected void setCommands() {
		this.commandList.add(new PlayCommand());
		
		if (this.menuController.isUndoable()) {
			this.commandList.add(new UndoCommand());			
		}
		
		if (this.menuController.isRedoable()) {
			this.commandList.add(new RedoCommand());			
		}
		
		this.commandList.add(new SaveGameCommand());
		this.commandList.add(new RestoreGameCommand());
		this.commandList.add(new NewGameCommand());
		this.commandList.add(exitCommand);
	}

	protected void setController(MenuController menuController) {
		for(Command command : commandList){
			command.set(menuController);
		}
	}

	public void execute(MenuController menuController) {
		this.menuController = menuController;
		this.setCommands();
		this.setController(menuController);
		this.write();
		int option = this.getOption();
		commandList.get(option).execute();
	}

	private void write() {
		IO io = new IO();
		for (int i = 0; i < commandList.size(); i++) {
			io.writeln(" " + (i + 1) + ". " + commandList.get(i).getTitle());
		}
	}

	private int getOption() {
		return LimitedIntDialog.instance().read("Select option", 1, commandList.size()) - 1;
	}
}
