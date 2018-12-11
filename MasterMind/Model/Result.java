package MasterMind.Model;

public class Result {
	
	public static final int COMBINATION_LENGTH = 4;
	
	public Success[] success;
	
	public Result ()
	{
		this.clear();
	}
	
	public Result (Result result)
	{
		this.success = result.success;
	}
	
	public void clear() {
		this.success = new Success[COMBINATION_LENGTH];
		for (int i = 0; i < this.success.length; i++) {
			this.success[i] = null;
		}
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
		return true;
	}
}
