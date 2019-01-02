package MasterMind.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import MasterMind.Model.Game;
import MasterMind.Model.State;


public class MenuController extends OperationController {
	
	private static final String filename = "MasterMindSaveGame.txt";
		
	public MenuController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

	public void playGame() {
		assert this.game.getState() == State.MENU;
		this.game.setState(State.PLAYING);
	}

	public void undo() {
		assert this.game.getState() == State.MENU;
		if (game.careTaker.isPrevious()) {
			this.restoreFromMemento(game.careTaker.getPrevious());
		}
	}

	public void redo() {
		assert this.game.getState() == State.MENU;
		if (game.careTaker.isNext()) {
			this.restoreFromMemento(game.careTaker.getNext());
		}
	}

	public void endGame() {
		Game newGame = new Game();
		game.copy(newGame);
	}

	public void saveGame() {
		try {
			FileOutputStream fos = new FileOutputStream(new File(filename));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public void restoreGame() {		
		try {
			FileInputStream fis = new FileInputStream(new File(filename));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Game restoredGame = (Game) ois.readObject();
			game.copy(restoredGame);
			
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public void saveGameJSON() {
		try {				
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			System.out.println(gson.toJson(game));
			
			Writer writer = new FileWriter(filename);
			gson.toJson(game, writer);
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	
	public void restoreGameJSON() {
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting().serializeNulls();
			Gson gson = builder.create();
			
			Reader reader = new FileReader(filename);
			Game restoredGame = gson.fromJson(reader, Game.class);  

			game.copy(restoredGame);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}