package MasterMind.Controllers;

public interface OperationControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(ReadController redController);
	
	void visit(ContinueController continueController);

}
