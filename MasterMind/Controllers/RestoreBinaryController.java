package MasterMind.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import MasterMind.Model.GameLocal;
import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class RestoreBinaryController implements RestoreControllerImpl {
	
	GameInterface game;
		
	public RestoreBinaryController(GameInterface game) {
		this.game = game;
	}

	public boolean restoreGame(String filename) {
		this.game.setState(State.IN_GAME);
		try {
			FileInputStream fis = new FileInputStream(new File(filename + ".bin"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			GameLocal restoredGame = (GameLocal) ois.readObject();
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
