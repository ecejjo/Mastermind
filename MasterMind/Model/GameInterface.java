package MasterMind.Model;

import MasterMind.Controllers.CareTaker;

public interface GameInterface {

	GameInterface data();
	
	void newGame();

	State getState();
	
	void setState(State menu);

	SecretCombination getSecretCombination();

	ProposedCombination[] getProposedCombinations();
	
	void addProposedCombination(ProposedCombination proposedCombination);

	void copyGame(GameStandalone savedState);

	CareTaker getCareTaker();

	void calculateResult();

	boolean isWinner();

	boolean moreTries();

	int getTries();

	void exitGame();
	
	boolean inGame();
}
