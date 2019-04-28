package MasterMind.Model;

public enum State {
	MENU_NOT_IN_GAME (0),
	MENU_IN_GAME (1),
	NEW_GAME (2),
	PLAY (3),
	UNDO (4),
	REDO (5),
	SAVE (6),
	RESTORE (7),
	EXIT_GAME (8),
	EXIT_APP (9),
	EXIT (11),
	LAST (10);
	
	private int value;
	
	State (int newValue) {
        value = newValue;
    }
	
	public int getValue() {
		return value;
	}

}
