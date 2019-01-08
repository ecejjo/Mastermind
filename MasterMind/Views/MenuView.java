package MasterMind.Views;

import MasterMind.Controllers.MenuController;
import MasterMind.Views.Menu.Menu;

public class MenuView {
	
	public MenuView() {
		// TODO Auto-generated constructor stub
	}

	public void interact(MenuController menuController) {
		new GameView(menuController).print();
		new Menu().execute(menuController);						
	}
}
