package MasterMind.Model;

import MasterMind.Controllers.CareTaker;

public interface GameInterface {
	
	void newGame();

	State getState();
	
	void setState(State menu);

	SecretCombination getSecretCombination();

	ProposedCombination[] getProposedCombinations();
	
	void add(ProposedCombination proposedCombination);

	void copy(GameLocal savedState);

	CareTaker getCareTaker();

	void calculateResult();

	boolean isWinner();

	boolean moreTries();

	int getTries();

	void abortGame();
	
	boolean inGame();
}
