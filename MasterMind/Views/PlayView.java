package MasterMind.Views;

import MasterMind.Controllers.PlayController;
import MasterMind.Util.IO;

public class PlayView {
	
	private IO io = new IO();
	
	public void interact(PlayController playController) {

		ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
		playController.add(proposedCombinationView.read());
						
    	if (playController.isWinner())
    	{
    		io.writeln("==================");
    		io.writeln("Matches. You win!!");
    		io.writeln("==================");
    	}
    	else if ( ! playController.moreTries())
    	{
    		io.writeln("=========================");
    		io.writeln("End of tries. You loose!!");
    		io.writeln("=========================");
    	}
    	
   		playController.done();
    	
		io.writeln("Saving try ...");
		playController.saveGame();
	}
}
