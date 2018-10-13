package Views;

import MasterMind.Controllers.ContinueController;
import MasterMind.Controllers.OperationController;
import MasterMind.Controllers.OperationControllerVisitor;
import MasterMind.Controllers.ReadController;
import MasterMind.Controllers.StartController;
import MasterMind.Model.ProposedCombination;
import MasterMind.Util.IO;

public class MasterMindView implements OperationControllerVisitor {

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startController.start();
		new GameView(startController).print();
	}

	@Override
	public void visit(ReadController readController) {
		readController.start();
		new GameView(readController).print();
		
		Views.ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
		readController.add(proposedCombinationView.read());
				
    	if (readController.isWinner())
    	{
    		IO io = new IO();		
    		io.write("Matches. You win!!");
    		readController.end();
    	}
    	else if (! readController.moreTries())
    	{
    		IO io = new IO();		
    		io.write("End of tries. You loose!!");
    		readController.end();
    	}
		
	}

	@Override
	public void visit(ContinueController continueController) {
		continueController.start();

		IO io = new IO();
		char answer;
		do {
			answer = io.readChar("Play again? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
		
		continueController.end(answer);
		
	}

}
