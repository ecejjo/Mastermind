package MasterMind.Views;

import MasterMind.Controllers.MenuController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private MenuView menuView;
	
	public MasterMindView() {
		menuView = new MenuView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(MenuController controller) {
		menuView.interact(controller);
	}
}
