package MasterMind;

public class Result {
	
	public static final int COMBINATION_LENGTH = 4;
	
	public Success[] success;
	
	public Result ()
	{
		this.success = new Success[COMBINATION_LENGTH];
	}
	
	public void add(Success newItem) {
		int i = 0;
		while (this.success[i] != null) {
			i++;
		}
		this.success[i] = newItem;
	}
	
	public boolean isWinner() {
		for (int i = 0; i < this.success.length; i++) {
			if ( ! (this.success[i] == Success.BLACK)) {
				return false;
			}
		}
		
		IO io = new IO();
		io.write("You win!! Congratulations!!");
		return true;
	}

	public void print() {
		
		IO io = new IO();
		io.write(" - Result is: ");		

		for (int i = 0; i < this.success.length; i++) {
			if (!(this.success[i] == null)) {
				this.success[i].print();	
			}
		}		
	}
}
