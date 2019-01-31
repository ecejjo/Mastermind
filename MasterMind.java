
import MasterMind.Controllers.Logic;
import MasterMind.Controllers.OperationController;
import MasterMind.Views.MasterMindView;

public class MasterMind {
	
	private Logic logic;
	
	private MasterMindView view;
	
	public MasterMind() {
		logic = new Logic();
		view = new MasterMindView();
	}           
    
    public void play() {    	
    	OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				controller.setMasterMindView(view);
				view.interact(controller);
			}
		} while (controller != null);		
    }
        
    public static void main(String[] args) {
        new MasterMind().play();
    }
}
