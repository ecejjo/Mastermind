package MasterMind.Model;

public class Combination {
	
	protected Color[] colors;
	
	public static final int COMBINATION_LENGTH = 4;
	
	public Combination() {
		colors = new Color[COMBINATION_LENGTH];
	}
	
	public Combination(Combination combination) {
		this.colors = new Color[COMBINATION_LENGTH];
		
		if (combination != null) {
			for (int i = 0; i < combination.colors.length; i++) {
				this.colors[i] = combination.colors[i];
			}
		}
	}
	
	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}		

}
