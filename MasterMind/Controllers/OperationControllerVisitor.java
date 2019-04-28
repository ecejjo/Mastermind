
package MasterMind.Controllers;

public interface OperationControllerVisitor {
	void visit(MenuController menuController);
	void visit(MenuNotInGameController controller);
	void visit(MenuInGameController controller);
}
