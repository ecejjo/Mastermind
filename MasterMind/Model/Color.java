package MasterMind.Model;

public enum Color {
	RED('R'),
	GREEN('G'),
	YELLOW('Y'),
	PINK('P'),
	BLACK('B'),
	WHITE('W'),
	NONE('_');
				
	private char value;
	
	Color(char value){
		this.setValue(value);
	}
	
	public String toString() {
		return ""+getValue();
	}
	
	public static Color getRandomColor(){
	    return Color.values()[(int) (Math.random()*(Color.values().length -1))];
	}
	
	public int toInt() {
		return this.ordinal();
	}
	
	public static Color getColor(char inChar) {
		switch (inChar) {
			case 'R': return Color.RED;
			case 'G': return Color.GREEN;
			case 'Y': return Color.YELLOW;
			case 'P': return Color.PINK;
			case 'B': return Color.BLACK;
			case 'W': return Color.WHITE;
			case '_': return Color.NONE;
		}
		return Color.NONE;
	}

	public boolean isIncluded(Color[] color) {
		for (int i = 0; i < color.length; i++) {
			if (this.value == color[i].value) {
				return true;
			}
		}
		return false;
	}
	
	public void setValue(char value){
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
