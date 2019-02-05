package MasterMind.Views;

import MasterMind.Controllers.MenuNotInGameController;
import MasterMind.Views.Menu.MenuNotInGameCommand;

public class MenuNotInGameView extends MenuView {

	public MenuNotInGameView() {		
		startView = new NewGameView();
		restoreView = new RestoreView();
		exitAppView = new ExitAppView();
	}

	public void interact(MenuNotInGameController menuController) {
		new GameView(menuController).print();
		new MenuNotInGameCommand().execute(this, menuController);						
	}
}
