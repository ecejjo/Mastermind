package MasterMind;
	
public enum Success {
	WHITE('W'),
	BLACK('B');
	
	private char value;
		
	private Success(char value){
		this.setValue(value);
	}
	
	public String toString() {
		return ""+value;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public void print() {
		IO io = new IO();
		io.write(this.toString());		
	}
}
