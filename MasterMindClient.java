

import MasterMind.Controllers.OperationController;
import MasterMind.Distributed.LogicClient;
import MasterMind.Views.MasterMindView;

public class MasterMindClient {
	
	private LogicClient logic;
	
	private MasterMindView view;
	
	public MasterMindClient() {
		logic = new LogicClient();
		view = new MasterMindView();
	}           
    
    public void play() {
    	OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				view.interact(controller);
			}
		} while (controller != null);		
    }
        
    public static void main(String[] args) {
        new MasterMindClient().play();
    }
}
