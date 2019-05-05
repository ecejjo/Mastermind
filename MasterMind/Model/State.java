package MasterMind.Model;

public enum State {
	NOT_IN_GAME (0),
	IN_GAME (1),
	EXIT (11);
	
	private int value;
	
	State (int newValue) {
        value = newValue;
    }
	
	public void setValue(int newValue) {
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}

}
