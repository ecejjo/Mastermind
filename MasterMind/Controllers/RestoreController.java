package MasterMind.Controllers;

import MasterMind.Model.GameInterface;

public class RestoreController extends Controller {
	
    private RestoreControllerImpl impl;

	public RestoreController(GameInterface game, String format) {
		super(game);
        if (format.equals("JSON")) {
            impl = new RestoreJsonController(game);
        } else {
            impl = new RestoreBinaryController(game);
        }
    }
	
	public boolean restore() {
		return (impl.restoreGame(FILENAME));
	}
}
