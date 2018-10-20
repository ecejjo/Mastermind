package MasterMind.Util;

public class LimitedCharDialog {

	private String title;
	private String charInterval;
	
	private char[] charList;
	
	public LimitedCharDialog(String title, char[] charList){
		assert title != null;
		this.title = title;
		this.charList = charList;
		
		this.charInterval = " [";
		for (int i = 0; i < charList.length; i++) {
			this.charInterval += charList[i] + ", ";
		}
		
		this.charInterval = this.charInterval.trim();
	    this.charInterval = this.charInterval.substring(0, this.charInterval.length() - 1) + "]";
	}


	public char read(){
		IO io = new IO();
		char value;
		boolean ok = false;
		do {
			value = io.readChar(title + " " + charInterval + ": ");
			
			for (int i = 0; i < charList.length; i++) {
			    if (charList[i] == value) {
			        ok = true;
			        break;
			    }
			}

			if (!ok) {
				io.writeln("Error. Input character must be in: " + this.charInterval);
			}
		} while (!ok);
		return value;
	}
}
