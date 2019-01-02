package MasterMind.Views;

import MasterMind.Controllers.MenuController;
import MasterMind.Util.IO;
import MasterMind.Util.LimitedCharDialog;

public class MenuView {
	
	public MenuView() {
		// TODO Auto-generated constructor stub
	}

	public void interact(MenuController menuController) {
		
		new GameView(menuController).print();
		
		this.print();
		char option = this.readOption();
				
		switch (option) {
		case '1':
			menuController.playGame();
			break;
		case '2':
			menuController.undo();
			break;
		case '3':
			menuController.redo();
			break;
		case '4':
			menuController.saveGame();
			break;
		case '5':
			menuController.restoreGame();
			break;
		case '6':
			menuController.newGame();
			break;
		case '7':
			menuController.exitGame();
			break;
			
		default:
			break;
		}						
	}

	private char readOption() {
		char[] optionsList = {'1', '2', '3', '4', '5', '6', '7'};
		LimitedCharDialog limitedCharDialog = new LimitedCharDialog("Select option: ", optionsList);
		return limitedCharDialog.read();		
	}

	private void print() {
		IO io = new IO();
		io.writeln(" 1.- Play.");
		io.writeln(" 2.- Undo.");
		io.writeln(" 3.- Redo.");
		io.writeln(" 4.- Save game.");
		io.writeln(" 5.- Restore game.");
		io.writeln(" 6.- New game.");
		io.writeln(" 7.- Exit game.");
	}
}
