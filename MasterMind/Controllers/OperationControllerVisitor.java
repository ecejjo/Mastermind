package MasterMind.Controllers;

public interface OperationControllerVisitor {

	void visit(MenuController controller);
	void visit(NewGameController controller);
	void visit(PlayController controller);	
	void visit(UndoController controller);
	void visit(RedoController controller);
	void visit(SaveController controller);
	void visit(RestoreController controller);
	void visit(ExitAppController controller);
	void visit(ExitGameController controller);

}
