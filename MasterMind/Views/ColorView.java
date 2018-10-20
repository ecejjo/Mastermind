package MasterMind.Views;

import MasterMind.Model.Color;
import MasterMind.Util.IO;
import MasterMind.Util.LimitedCharDialog;

public class ColorView {
	
	Color color;
	
	ColorView (Color color) {
		this.color = color;
	}
	
	public ColorView() {
		// TODO Auto-generated constructor stub
	}

	public Color readColor() {
			
		char[] charList = new char[Color.values().length - 1];
		for (int i = 0; i < Color.values().length - 1; i++) {
			charList[i] = Color.values()[i].getValue();	
		}
			
		LimitedCharDialog limitedCharDialog = new LimitedCharDialog(" - Input char", charList);
		return Color.getColor(limitedCharDialog.read());
	}

	public void print() {
		IO io = new IO();
		io.write(String.valueOf(color.getValue()));
	}

}
