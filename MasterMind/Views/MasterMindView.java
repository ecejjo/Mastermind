package MasterMind.Views;

import MasterMind.Controllers.NewGameController;
import MasterMind.Controllers.UndoController;
import MasterMind.Controllers.PlayController;
import MasterMind.Controllers.RedoController;
import MasterMind.Controllers.RestoreController;
import MasterMind.Controllers.SaveController;
import MasterMind.Controllers.ExitGameController;
import MasterMind.Controllers.ExitAppController;
import MasterMind.Controllers.MenuController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;

public class MasterMindView implements OperationControllerVisitor {
	
	private NewGameView startView;
	private MenuView menuView;
	private PlayView playView;
	private UndoView undoView;
	private RedoView redoView;
	private SaveView saveView;
	private RestoreView restoreView;
	private ExitAppView exitAppView;
	private ExitGameView exitGameView;
	
	public MasterMindView() {
		startView = new NewGameView();
		menuView = new MenuView();
		playView = new PlayView();
		undoView = new UndoView();
		redoView = new RedoView();
		saveView = new SaveView();
		restoreView = new RestoreView();
		exitAppView = new ExitAppView();
		exitGameView = new ExitGameView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(NewGameController controller) {
		startView.interact(controller);
	}
	
	@Override
	public void visit(MenuController controller) {
		menuView.interact(controller);
	}

	@Override
	public void visit(PlayController controller) {
		playView.interact(controller);
	}
	
	@Override
	public void visit(UndoController controller) {
		undoView.interact(controller);
	}

	@Override
	public void visit(RedoController controller) {
		redoView.interact(controller);
	}
	
	@Override
	public void visit(SaveController controller) {
		saveView.interact(controller);
	}
	
	@Override
	public void visit(RestoreController controller) {
		restoreView.interact(controller);		
	}

	@Override
	public void visit(ExitAppController controller) {
		exitAppView.interact(controller);
	}

	@Override
	public void visit(ExitGameController controller) {
		exitGameView.interact(controller);		
	}
}
