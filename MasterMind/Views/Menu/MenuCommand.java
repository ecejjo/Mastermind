package MasterMind.Views.Menu;

import java.util.ArrayList;
import java.util.List;

import MasterMind.Controllers.MenuController;
import MasterMind.Util.IO;
import MasterMind.Util.LimitedIntDialog;
import MasterMind.Views.MenuView;

public abstract class MenuCommand {

	protected List<Command> commandList;
	
	protected MenuView menuView;
	
	protected MenuController menuController;

	public MenuCommand() {
		this.commandList = new ArrayList<Command>();
	}

	abstract void setCommands();
	
	protected void setController(MenuController menuController) {
		for(Command command : commandList){
			command.set(menuController);
		}
	}

	public void execute(MenuView menuView, MenuController menuController) {
		this.menuController = menuController;
		this.setCommands();
		this.setView(menuView);
		this.setController(menuController);
		this.write();
		int option = this.getOption();
		commandList.get(option).execute();
	}

	protected void setView(MenuView menuView) {
		this.menuView = menuView;
		for(Command command : commandList){
			command.setView(this.menuView);
		}
	}

	protected void write() {
		IO io = new IO();
		for (int i = 0; i < commandList.size(); i++) {
			io.writeln(" " + (i + 1) + ". " + commandList.get(i).getTitle());
		}
	}

	protected int getOption() {
		return LimitedIntDialog.instance().read("Select option", 1, commandList.size()) - 1;
	}
}
