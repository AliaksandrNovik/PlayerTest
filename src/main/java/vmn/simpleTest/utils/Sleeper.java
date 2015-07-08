package vmn.simpleTest.utils;

public class Sleeper {
	private static Sleeper instance = new Sleeper();

	public static Sleeper getInstance() {
		if (instance == null) {
			instance = new Sleeper();
		}
		return instance;
	}

	public void sleep(long millSec) {
		try {
			Thread.sleep(millSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
