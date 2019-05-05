package MasterMind.Controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.GameStandalone;
import MasterMind.Model.GameInterface;
import MasterMind.Model.State;


public class RestoreJsonController implements RestoreControllerImpl {
	
	GameInterface game;
		
	public RestoreJsonController(GameInterface game) {
		this.game = game;
	}
	
	public boolean restoreGame(String filename) {
		this.game.setState(State.IN_GAME);
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			Reader reader = new FileReader(filename + ".json");
			GameStandalone restoredGame = gson.fromJson(reader, GameStandalone.class);  

			game.copyGame(restoredGame);
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return false;
	}
}
