package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.State;
import MasterMind.Views.MasterMindView;

public class MenuNotInGameController extends MenuController {
	
	private NewGameController newGameController;	
	private RestoreController restoreController;
	private ExitAppController exitAppController;
		
	public MenuNotInGameController(GameInterface game) {
		super(game);
		newGameController = new NewGameController(game);
		restoreController = new RestoreController(game, "JSON");
		exitAppController = new ExitAppController(game);
	}
	
	@Override
	public void setMasterMindView(MasterMindView view) {
		masterMindView = view;
		newGameController.setMasterMindView(view);
		restoreController.setMasterMindView(view);
		exitAppController.setMasterMindView(view);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

	public boolean inGame() {
		return this.game.getState() == State.MENU_IN_GAME;
	}
	
	public boolean moreTries() {
		return this.game.moreTries();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}
	
	public void newGame() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		newGameController.newGame();
	}
	
	public boolean isUndoable() {
		return this.game.getCareTaker().previousExists();
	}

	public boolean isRedoable() {
		return this.game.getCareTaker().nextExists();
	}
	
	public void restoreGame() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		restoreController.restore();
	}
		
	public void exitApp() {
		assert this.game.getState() == State.MENU_NOT_IN_GAME;
		exitAppController.exitApp();
	}

	public NewGameController getNewGameController() {
		return newGameController;
	}

	public void setNewGameController(NewGameController newGameController) {
		this.newGameController = newGameController;
	}

	public RestoreController getRestoreController() {
		return restoreController;
	}

	public void setRestoreController(RestoreController restoreController) {
		this.restoreController = restoreController;
	}

	public ExitAppController getExitAppController() {
		return exitAppController;
	}

	public void setExitAppController(ExitAppController exitAppController) {
		this.exitAppController = exitAppController;
	}
}
