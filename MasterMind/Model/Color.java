package MasterMind.Model;

import MasterMind.Util.IO;

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
