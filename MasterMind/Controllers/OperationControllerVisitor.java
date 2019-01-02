package MasterMind.Controllers;

public interface OperationControllerVisitor {
	
	void visit(StartController startController);
	void visit(MenuController menuController);
	void visit(ReadController readController);	
	void visit(UndoController undoController);
	void visit(RedoController redoController);
	void visit(ContinueController continueController);

}
