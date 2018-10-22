package MasterMind.Model;
import MasterMind.Util.IO;
import java.util.HashMap;
import java.util.Map;

public enum Color {
	RED('R'),
	GREEN('G'),
	YELLOW('Y'),
	PINK('P'),
	BLACK('B'),
	WHITE('W'),
	NONE('_');
				
	private char value;
	
    private static final Map <Character, Color> lookup = new HashMap<Character, Color>();
    
	Color(char value){
		this.setValue(value);
	}

    static {
        for (Color c : Color.values()) {
            lookup.put(c.getValue(), c);
        }
    }
    		
	public static Color getColor(char inChar) {
        return lookup.get(inChar);
    }
		
	public static Color getRandomColor(){
	    return Color.values()[(int) (Math.random()*(Color.values().length -1))];
	}
	
	public void print() {
		IO io = new IO();
		io.write(String.valueOf(getValue()));
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
