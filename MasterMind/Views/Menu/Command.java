package MasterMind.Views.Menu;

import MasterMind.Controllers.MenuController;

public abstract class Command {

	private String title;

	protected MenuController menuController;

	protected Command(String title) {
		this.title = title;
	}

	public void set(MenuController menuController) {
		this.menuController = menuController;
	}

	public String getTitle() {
		return title;
	}

	public abstract void execute();
}
