package MasterMind.Views;

import MasterMind.Controllers.PlayController;
import MasterMind.Util.IO;

public class PlayView {
	
	private IO io = new IO();
	
	public void interact(PlayController readController) {
		readController.start();		
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
    	else
    	{
    		readController.done();
    	}
    	
		io.writeln("Saving try ...");
		readController.saveGame();
	}
}
