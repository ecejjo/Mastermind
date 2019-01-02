package MasterMind.Views;

import MasterMind.Controllers.StartController;
import MasterMind.Controllers.UndoController;
import MasterMind.Controllers.PlayController;
import MasterMind.Controllers.RedoController;
import MasterMind.Controllers.RestoreController;
import MasterMind.Controllers.SaveController;
import MasterMind.Controllers.ContinueController;
import MasterMind.Controllers.MenuController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private StartView startView;
	private MenuView menuView;
	private PlayView readView;
	private UndoView undoView;
	private RedoView redoView;
	private SaveView saveView;
	private RestoreView restoreView;
	private ContinueView continueView;
	
	public MasterMindView() {
		startView = new StartView();
		menuView = new MenuView();
		readView = new PlayView();
		undoView = new UndoView();
		redoView = new RedoView();
		saveView = new SaveView();
		restoreView = new RestoreView();
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
	public void visit(MenuController menuController) {
		menuView.interact(menuController);
	}

	@Override
	public void visit(PlayController readController) {
		readView.interact(readController);
	}
	
	@Override
	public void visit(UndoController undoController) {
		undoView.interact(undoController);
	}

	@Override
	public void visit(RedoController redoController) {
		redoView.interact(redoController);
	}
	
	@Override
	public void visit(SaveController saveController) {
		saveView.interact(saveController);
	}
	
	@Override
	public void visit(RestoreController restoreController) {
		restoreView.interact(restoreController);		
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}
}
