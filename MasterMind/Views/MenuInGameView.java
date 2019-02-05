package MasterMind.Views;

import MasterMind.Controllers.MenuInGameController;
import MasterMind.Views.Menu.MenuInGameCommand;

public class MenuInGameView extends MenuView {

	public MenuInGameView() {
		playView = new PlayView();
		undoView = new UndoView();
		redoView = new RedoView();
		saveView = new SaveView();
		exitGameView = new ExitGameView();
	}

	public void interact(MenuInGameController menuController) {
		new GameView(menuController).print();
		new MenuInGameCommand().execute(this, menuController);		
	}
}
