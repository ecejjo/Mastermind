package MasterMind.Util;

import java.util.ArrayList;

import MasterMind.Model.Color;

public class LimitedCharDialog {

	private String title;
	
	private ArrayList <Character> charList;
	
	public LimitedCharDialog(String title, ArrayList <Character> charList){
		assert title != null;
		this.title = title + " " + charList + ": ";
		this.charList = charList;
	}


	public char read(){
		IO io = new IO();
		char value;
		boolean ok;
		do {
			value = io.readChar(title);
			ok = charList.contains(value);
			if (!ok) {
				io.writeln("Error. Input character must be in: " + charList);
			}
		} while (!ok);
		return value;
	}

	static public Color readColor() {
		
		ArrayList <Character> charList = new ArrayList<>();
		for (int i = 0; i < Color.values().length - 1; i++) {
			charList.add(Color.values()[i].getValue());	
		}
		
		LimitedCharDialog limitedCharDialog = new LimitedCharDialog(" - Input char", charList);
		// return Color(limitedCharDialog.read());
		
		switch (limitedCharDialog.read()) {
			case 'R': return Color.RED;
			case 'G': return Color.GREEN;
			case 'Y': return Color.YELLOW;
			case 'P': return Color.PINK;
			case 'B': return Color.BLACK;
			case 'W': return Color.WHITE;
			case '_': return Color.NONE;
		}
		return null;	
	}
}
