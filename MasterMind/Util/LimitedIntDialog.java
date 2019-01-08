package MasterMind.Util;

public class LimitedIntDialog {

	private static LimitedIntDialog limitedIntDialog;

	public static LimitedIntDialog instance() {
		if (limitedIntDialog == null) {
			limitedIntDialog = new LimitedIntDialog();
		}
		return limitedIntDialog;
	}

	private LimitedIntDialog() {

	}

	public int read(String title, int min, int max) {
		assert title != null;
		ClosedInterval limits = new ClosedInterval(min, max);
		ClosedIntervalView limitsView = new ClosedIntervalView(
				"Value must be in the limits", limits);
		int value;
		boolean ok;
		do {
			IO io = new IO();
			value = io.readInt(title + " " + limitsView + ": ");
			ok = limits.includes(value);
			if (!ok) {
				limitsView.writeln();
			}
		} while (!ok);
		return value;
	}

	public int read(String title, int max) {
		return this.read(title, 1, max);
	}
}
