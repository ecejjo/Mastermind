package MasterMind.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.Game;
import MasterMind.Model.State;


public class RestoreController extends OperationController {
		
	public RestoreController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

	public boolean restoreGameBinary() {
		this.game.setState(State.MENU);
		try {
			FileInputStream fis = new FileInputStream(new File(filename));
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
	
	public boolean restoreGameJSON() {
		this.game.setState(State.MENU);
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			Reader reader = new FileReader(filename);
			Game restoredGame = gson.fromJson(reader, Game.class);  

			game.copy(restoredGame);
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return false;
	}

}
