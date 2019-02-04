package MasterMind.Views;

import MasterMind.Controllers.MenuController;
import MasterMind.Views.Menu.MenuCommand;

public class MenuView {

	private NewGameView startView;
	private PlayView playView;
	private UndoView undoView;
	private RedoView redoView;
	private SaveView saveView;
	private RestoreView restoreView;
	private ExitAppView exitAppView;
	private ExitGameView exitGameView;

	public MenuView() {
		setStartView(new NewGameView());
		setPlayView(new PlayView());
		setUndoView(new UndoView());
		setRedoView(new RedoView());
		setSaveView(new SaveView());
		setRestoreView(new RestoreView());
		setExitAppView(new ExitAppView());
		setExitGameView(new ExitGameView());
	}

	public void interact(MenuController menuController) {
		new GameView(menuController).print();
		new MenuCommand().execute(this, menuController);						
	}

	public NewGameView getStartView() {
		return startView;
	}

	public void setStartView(NewGameView startView) {
		this.startView = startView;
	}

	public PlayView getPlayView() {
		return playView;
	}

	public void setPlayView(PlayView playView) {
		this.playView = playView;
	}

	public UndoView getUndoView() {
		return undoView;
	}

	public void setUndoView(UndoView undoView) {
		this.undoView = undoView;
	}

	public RedoView getRedoView() {
		return redoView;
	}

	public void setRedoView(RedoView redoView) {
		this.redoView = redoView;
	}

	public SaveView getSaveView() {
		return saveView;
	}

	public void setSaveView(SaveView saveView) {
		this.saveView = saveView;
	}

	public RestoreView getRestoreView() {
		return restoreView;
	}

	public void setRestoreView(RestoreView restoreView) {
		this.restoreView = restoreView;
	}

	public ExitAppView getExitAppView() {
		return exitAppView;
	}

	public void setExitAppView(ExitAppView exitAppView) {
		this.exitAppView = exitAppView;
	}

	public ExitGameView getExitGameView() {
		return exitGameView;
	}

	public void setExitGameView(ExitGameView exitGameView) {
		this.exitGameView = exitGameView;
	}
}
