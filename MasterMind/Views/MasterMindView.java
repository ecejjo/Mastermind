package MasterMind.Views;

import MasterMind.Controllers.NewGameController;
import MasterMind.Controllers.UndoController;
import MasterMind.Controllers.PlayController;
import MasterMind.Controllers.RedoController;
import MasterMind.Controllers.RestoreController;
import MasterMind.Controllers.SaveController;
import MasterMind.Controllers.AbortController;
import MasterMind.Controllers.ExitController;
import MasterMind.Controllers.MenuController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private NewGameView startView;
	private MenuView menuView;
	private PlayView readView;
	private UndoView undoView;
	private RedoView redoView;
	private SaveView saveView;
	private RestoreView restoreView;
	private ExitView continueView;
	private AbortView abortView;
	
	public MasterMindView() {
		startView = new NewGameView();
		menuView = new MenuView();
		readView = new PlayView();
		undoView = new UndoView();
		redoView = new RedoView();
		saveView = new SaveView();
		restoreView = new RestoreView();
		continueView = new ExitView();
		abortView = new AbortView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(NewGameController startController) {
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
	public void visit(ExitController continueController) {
		continueView.interact(continueController);
	}

	@Override
	public void visit(AbortController abortController) {
		abortView.interact(abortController);		
	}
}
