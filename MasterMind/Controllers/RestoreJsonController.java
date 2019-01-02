package MasterMind.Controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.Game;
import MasterMind.Model.State;


public class RestoreJsonController implements RestoreControllerImpl {
	
	Game game;
		
	public RestoreJsonController(Game game) {
		this.game = game;
	}
	
	public boolean restoreGame(String filename) {
		this.game.setState(State.MENU);
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			Reader reader = new FileReader(filename + ".json");
			Game restoredGame = gson.fromJson(reader, Game.class);  

			game.copy(restoredGame);
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return false;
	}
}
