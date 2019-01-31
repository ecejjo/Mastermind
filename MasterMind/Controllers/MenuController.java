package MasterMind.Controllers;

import java.util.ArrayList;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;
import MasterMind.Views.MasterMindView;

public class MenuController extends OperationController {
	
	private ArrayList<OperationController> controllersList;
		
	public MenuController(GameInterface game) {
		super(game);
		controllersList = new ArrayList<OperationController>();
	}

	public void add(OperationController controller)
	{
		controllersList.add(controller);
	}
	
	@Override
	public void setMasterMindView(MasterMindView view) {
		masterMindView = view;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).setMasterMindView(view);
		}
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void newGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).newGame();
		}
	}

	public void playGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).playGame();
		}
	}
	
	public boolean inGame() {
		assert this.game.getState() == State.MENU;
		return (this.game.inGame());
	}
	
	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}

	public void undo() {
		assert this.game.getState() == State.MENU;
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).undo();
		}
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public void redo() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).redo();
		}
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}

	public void saveGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).saveGame();
		}
	}
	
	public void restoreGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).restoreGame();
		}
	}
	
	public void abortGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).abortGame();
		}
	}
	
	public void exitGame() {
		assert this.game.getState() == State.MENU;
		for (int i = 0; i < this.controllersList.size(); i++) {
			this.controllersList.get(i).exitGame();
		}
	}
}
