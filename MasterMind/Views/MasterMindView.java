package MasterMind.Views;

import MasterMind.Controllers.StartController;
import MasterMind.Controllers.ReadController;
import MasterMind.Controllers.ContinueController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private StartView startView;
	private ReadView readView;
	private ContinueView continueView;
	
	public MasterMindView() {
		startView = new StartView();
		readView = new ReadView();
		continueView = new ContinueView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(ReadController readController) {
		readView.interact(readController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}
}
