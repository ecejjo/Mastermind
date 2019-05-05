package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class SaveController extends Controller {
	
    private SaveControllerImpl impl;
		
	public SaveController(GameInterface game, FileFormat fileFormat) {
		super(game);
        if (fileFormat == FileFormat.JSON) {
            impl = new SaveJsonController(game.data());
        } else {
            impl = new SaveBinaryController(game.data());
        }
    }
	
	public boolean saveGame() {
		return (impl.saveGame(FILENAME));
	}
}
