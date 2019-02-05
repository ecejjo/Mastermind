package MasterMind.Views;

public class MenuView {

	protected NewGameView startView;
	protected PlayView playView;
	protected UndoView undoView;
	protected RedoView redoView;
	protected SaveView saveView;
	protected RestoreView restoreView;
	protected ExitGameView exitGameView;
	protected ExitAppView exitAppView;

	public MenuView() {
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
