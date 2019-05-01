package MasterMind.Controllers;

import java.util.HashMap;
import java.util.Map;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;

public class MenuController extends OperationController {
	
	private Map<ControllerEnum, Controller> controllersList;

	public MenuController(GameInterface game) {
		super(game);
		this.controllersList = new HashMap<ControllerEnum, Controller>();
	}
	
	public void put(ControllerEnum controllerEnum, Controller controller) {
		this.controllersList.put(controllerEnum, controller);		
	}

	public Controller getController(ControllerEnum controllerEnum) {
		return this.controllersList.get(controllerEnum);
	}

	public Controller getController(State state) {
		switch (state) {
		case IN_GAME:
			return this.controllersList.get(ControllerEnum.MENU_IN_GAME);
		case NOT_IN_GAME:
			return this.controllersList.get(ControllerEnum.MENU_NOT_IN_GAME);
		default:
			break;
		}
		return null;
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
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
