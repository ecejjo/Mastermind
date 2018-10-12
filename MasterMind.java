
import MasterMind.Controllers.Controller;
import MasterMind.Controllers.Logic;

public class MasterMind {
	
	private Logic logic;
	
	public MasterMind() {
		logic = new Logic();
	}           
    
    public void play() {    	
    	Controller controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				controller.control();
			}
		} while (controller != null);		
    }
        
    public static void main(String[] args) {
        new MasterMind().play();
    }
}
