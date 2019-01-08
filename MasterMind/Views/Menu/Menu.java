package MasterMind.Views.Menu;

import java.util.ArrayList;
import java.util.List;

import MasterMind.Controllers.MenuController;
import MasterMind.Util.IO;
import MasterMind.Util.LimitedIntDialog;

public class Menu {

	protected List<Command> commandList;

	private ExitCommand exitCommand;

	public Menu() {
		this.commandList = new ArrayList<Command>();
		this.setCommands();
		exitCommand = new ExitCommand();
		this.commandList.add(exitCommand);
	}

	protected void setCommands() {
		commandList.add(new PlayCommand());
		commandList.add(new UndoCommand());
		commandList.add(new RedoCommand());
		commandList.add(new SaveGameCommand());
		commandList.add(new RestoreGameCommand());
		commandList.add(new NewGameCommand());
	}

	protected void set(MenuController menuController) {
		for(Command command : commandList){
			command.set(menuController);
		}
	}

	public void execute(MenuController menuController) {
		this.set(menuController);
		exitCommand.reset();
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

	public boolean isClosed() {
		return exitCommand.closed();
	}
}
