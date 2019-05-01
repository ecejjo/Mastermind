package MasterMind.Controllers;

import java.util.HashMap;
import java.util.Map;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuController extends OperationController {
	
	private Map<State, Controller> controllersList;

	public MenuController(GameInterface game) {
		super(game);
		this.controllersList = new HashMap<State, Controller>();
	}
	
	public void put(State state, Controller controller) {
		this.controllersList.put(state, controller);		
	}

	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}
	
	public Controller getController(State state) {
		return this.controllersList.get(state);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
