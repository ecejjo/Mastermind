package MasterMind.Model;

import MasterMind.Util.IO;

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

}
