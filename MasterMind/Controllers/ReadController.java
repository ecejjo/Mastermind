package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.ProposedCombination;
import MasterMind.Model.State;

public class ReadController extends OperationController {
		
	public ReadController(Game game) {
		super(game);		
	}	
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
	
	public void start() {
		assert this.game.getState() == State.PLAYING;
	}
	
	public void add(ProposedCombination proposedCombination) {
		this.game.add(proposedCombination);
	}
	
	public void calculateResult() {
		this.game.calculateResult();
	}
	
	public boolean isWinner() {
		return game.isWinner();
	}
	
	public boolean moreTries() {
		return game.moreTries();
	}
	
	public void end() {
		this.game.setState(State.FINAL);
	}

}
