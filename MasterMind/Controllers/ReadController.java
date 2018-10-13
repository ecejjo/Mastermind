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
		assert this.getState() == State.PLAYING;
	}
	
	public void add(ProposedCombination proposedCombination) {
		this.getGame().add(proposedCombination);
	}
	
	public void end() {
		this.setState(State.FINAL);
	}

}
