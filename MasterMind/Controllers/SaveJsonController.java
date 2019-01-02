package MasterMind.Controllers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.Game;
import MasterMind.Model.State;


public class SaveJsonController implements SaveControllerImpl {
	
	Game game;
			
	public SaveJsonController(Game game) {
		this.game = game;
	}
	
	public boolean saveGame(String filename) {
		this.game.setState(State.MENU);
		try {				
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			// System.out.println(gson.toJson(game));
			
			Writer writer = new FileWriter(filename + ".json");
			gson.toJson(game, writer);
			writer.close();
			return true;
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		return false;
	}
}
