package MasterMind.Views;

import MasterMind.Model.Result;

public class ResultView {
	
	Result result;
	
	public ResultView(Result result) {
		this.result = result;
	}

	public void print() {
		for (int i = 0; i < this.result.success.length; i++) {
			if (!(this.result.success[i] == null)) {
				new SuccessView(this.result.success[i]).print();	
			}
		}
	}
}
