package MasterMind.Views;

import MasterMind.Controllers.ReadController;
import MasterMind.Util.IO;

public class ReadView {
	
	private IO io = new IO();
	
	public void interact(ReadController readController) {
		readController.start();
		new GameView(readController).print();
		
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
		readController.add(proposedCombinationView.read());
		readController.calculateResult();
				
    	if (readController.isWinner())
    	{
    		io.writeln("Matches. You win!!");
    		readController.end();
    	}
    	else if (! readController.moreTries())
    	{
    		io.writeln("End of tries. You loose!!");
    		readController.end();
    	}
	}
}
