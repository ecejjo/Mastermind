package MasterMind.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import MasterMind.Model.GameInterface;
import MasterMind.Model.State;


public class SaveBinaryController implements SaveControllerImpl {
	
	GameInterface game;
			
	public SaveBinaryController(GameInterface game) {
		this.game = game;
	}
	
	public boolean saveGame(String filename) {
		this.game.setState(State.MENU);
		try {
			FileOutputStream fos = new FileOutputStream(new File(filename + ".bin"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);			
			oos.close();
			fos.close();
			return true;
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		return false;
	}
}
