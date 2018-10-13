package Views;

import MasterMind.Model.Success;
import MasterMind.Util.IO;

public class SuccessView {
	
	Success success;
	
	SuccessView (Success success) {
		this.success = success;
	}

	public void print() {
		IO io = new IO();
		io.write(this.toString());		
	}

}
