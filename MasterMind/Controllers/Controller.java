package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.SecretCombination;

public abstract class Controller {

	protected Game game;
	
	protected static final String FILENAME = "MasterMindSaveGame";

	protected Controller(Game game) {
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
		Game gameToSave = new Game(game);
        return new Memento(gameToSave); 
    }

    public void restoreFromMemento(Memento m) 
    {
        game.copy(m.getSavedState());
    }
}
