package MasterMind.Controllers;

import MasterMind.Model.GameInterface;
import MasterMind.Views.MasterMindView;

public abstract class OperationController extends Controller  {
	
	MasterMindView masterMindView;

	protected OperationController(GameInterface game) {
		super(game);
	}
	
	public abstract void accept(OperationControllerVisitor operationControllerVisitor);

	public void setMasterMindView(MasterMindView view) {
		masterMindView = view;
	}
	
	public MasterMindView getMasterMindView() {
		return masterMindView;
	}
}
