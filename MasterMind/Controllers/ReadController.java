package MasterMind.Controllers;

import MasterMind.Model.Game;
import MasterMind.Model.State;
import MasterMind.Util.IO;

public class ReadController extends Controller {
		
	public ReadController(Game game) {
		super(game);		
	}

	public void control() {
		assert this.getState() == State.PLAYING;

		this.getGame().read();
		
		this.getGame().print();
		
    	if (this.isWinner())
    	{
    		IO io = new IO();		
    		io.write("Matches. You win!!");
    		this.getGame().setState(State.FINAL);
    	}
    	else if (! this.moreTries())
    	{
    		IO io = new IO();		
    		io.write("End of tries. You loose!!");
    		this.getGame().setState(State.FINAL);
    		return;
    	}
	}	
}
