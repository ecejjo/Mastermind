package MasterMind.Views;

import MasterMind.Controllers.MenuInGameController;
import MasterMind.Controllers.MenuNotInGameController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private MenuNotInGameView menuNotInGameView;
	private MenuInGameView menuInGameView;
	
	public MasterMindView() {
		menuNotInGameView = new MenuNotInGameView();
		menuInGameView = new MenuInGameView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(MenuNotInGameController controller) {
		menuNotInGameView.interact(controller);
	}

	@Override
	public void visit(MenuInGameController controller) {
		menuInGameView.interact(controller);		
	}
}
