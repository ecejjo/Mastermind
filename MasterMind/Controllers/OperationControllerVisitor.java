
package MasterMind.Controllers;

public interface OperationControllerVisitor {
	void visit(MenuNotInGameController controller);
	void visit(MenuInGameController controller);
}
