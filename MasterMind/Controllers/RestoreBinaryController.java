package MasterMind.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import MasterMind.Model.Game;
import MasterMind.Model.State;

public class RestoreBinaryController implements RestoreControllerImpl {
	
	Game game;
		
	public RestoreBinaryController(Game game) {
		this.game = game;
	}

	public boolean restoreGame(String filename) {
		this.game.setState(State.MENU);
		try {
			FileInputStream fis = new FileInputStream(new File(filename + ".bin"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Game restoredGame = (Game) ois.readObject();
			game.copy(restoredGame);
			
			ois.close();
			fis.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
