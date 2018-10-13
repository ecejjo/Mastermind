package Views;

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

	public Color read() {
		return LimitedCharDialog.readColor();
	}

	public void print() {
		IO io = new IO();
		io.write(String.valueOf(color.getValue()));
	}

}
