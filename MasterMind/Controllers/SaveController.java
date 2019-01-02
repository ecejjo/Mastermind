package MasterMind.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.Game;
import MasterMind.Model.State;


public class SaveController extends OperationController {
	
	private static final String filename = "MasterMindSaveGame.txt";
		
	public SaveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

	public boolean saveGameBinary() {
		this.game.setState(State.MENU);
		try {
			FileOutputStream fos = new FileOutputStream(new File(filename));
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
	
	public boolean saveGameJSON() {
		this.game.setState(State.MENU);
		try {				
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			// System.out.println(gson.toJson(game));
			
			Writer writer = new FileWriter(filename);
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
