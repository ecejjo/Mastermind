package MasterMind.Controllers;

public interface OperationControllerVisitor {
	
	void visit(NewGameController startController);
	void visit(MenuController menuController);
	void visit(PlayController readController);	
	void visit(UndoController undoController);
	void visit(RedoController redoController);
	void visit(SaveController saveController);
	void visit(RestoreController restoreController);
	void visit(ExitController continueController);
	void visit(AbortController abortController);

}
