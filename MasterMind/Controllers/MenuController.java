package MasterMind.Controllers;

import java.util.ArrayList;
import java.util.List;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuController extends OperationController {
	
	private List<Controller> controllersList;

	public MenuController(GameInterface game) {
		super(game);
		controllersList = new ArrayList<Controller>();
	}
	
	public void addController(State menuInGame, Controller controller) {
		for (int i = controllersList.size(); i < menuInGame.getValue(); i++) {
			controllersList.add(i, controller);
		}
		controllersList.add(menuInGame.getValue(), controller);
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
		return this.controllersList.get(state.getValue());
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
