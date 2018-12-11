package MasterMind.Controllers;

import MasterMind.Model.Game;

public class Logic {
	
	private Game game;
	
	public CareTaker careTaker; 
	
	private StartController startController;
	
	private ReadController readController;

	private ContinueController continueController;
	
	public Logic() {
		game = new Game();
	    careTaker = new CareTaker();
		startController = new StartController(game);
		readController = new ReadController(game);
		continueController = new ContinueController(game);
	}

	public OperationController getController() {
		switch (game.getState()) {
			case INITIAL:
			return startController;
			case PLAYING:
			return readController;
			case FINAL:
			return continueController;
			case EXIT:
			default:
			return null;
		}
	}
	
	public void saveGame(OperationController controller) throws CloneNotSupportedException {
		this.careTaker.add(controller.saveToMemento());
	}
}
