package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public abstract class OperationController extends Controller  {

	protected OperationController(GameInterface game) {
		super(game);
	}

	public abstract void accept(OperationControllerVisitor operationControllerVisitor);
}
