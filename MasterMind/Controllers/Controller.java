package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Model.GameLocal;
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
		GameLocal gameToSave = new GameLocal(game);
        return new Memento(gameToSave); 
    }

    public void restoreFromMemento(Memento m) 
    {
        game.copy(m.getSavedState());
    }
}
