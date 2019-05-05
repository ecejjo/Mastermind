package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.GameStandalone;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.SecretCombination;

public abstract class Controller {

	protected GameInterface game;
	
	protected static final String FILENAME = "MasterMindSaveGame";

	protected Controller(GameInterface game) {
		assert game != null;
		this.game = game;
	}

	public SecretCombination getSecretCombination() {
		return game.getSecretCombination();
	}

	public ProposedCombination[] getProposedCombinations() {
		return game.getProposedCombinations();
	}
	
	public Memento saveToMemento() 
    {
		GameStandalone gameToSave = new GameStandalone(game);
        return new Memento(gameToSave); 
    }

    public void restoreFromMemento(Memento m) 
    {
        game.copyGame(m.getSavedState());
    }
}
