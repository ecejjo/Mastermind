package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class SaveController extends Controller {
	
    private SaveControllerImpl impl;
		
	public SaveController(GameInterface game, String format) {
		super(game);
        if (format.equals("JSON")) {
            impl = new SaveJsonController(game);
        } else {
            impl = new SaveBinaryController(game);
        }
    }
	
	public boolean saveGame() {
		return (impl.saveGame(FILENAME));
	}
}
