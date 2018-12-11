package MasterMind.Controllers;

public interface OperationControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(MenuController menuController);
	
	void visit(ReadController readController);
	
	void visit(ContinueController continueController);

}
