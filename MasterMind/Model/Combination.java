package MasterMind.Model;

public class Combination {
	
	protected Color[] colors;
	
	public static final int COMBINATION_LENGTH = 4;
	
	public Combination() {
		colors = new Color[COMBINATION_LENGTH];
	}
	
	public Combination(Combination combination) {
		colors = new Color[COMBINATION_LENGTH];
		
		for (int i = 0; i < combination.colors.length; i++) {
			colors[i] = combination.colors[i];
		}

	}

	public Combination copy () {
		Combination copy = new Combination();		
		for (int i = 0; i < this.colors.length; i++) {
			copy.colors[i] = this.colors[i];
		}
		return copy;
	}

	public void print() {
		for (int i = 0; i < colors.length; i++) {
			colors[i].print();
		}
	}
	
	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}		

}
