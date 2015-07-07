package vmn.simpleTest.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	private static final Logger LOGGER = Logger.getLogger(Listener.class);

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("Test -  " + result.getMethod().getConstructorOrMethod().getName() + "started");
	}

	public void onTestSuccess(ITestResult result) {
		LOGGER.info("Test -  " + result.getMethod().getConstructorOrMethod().getName() + " succed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info("Test -  " + result.getMethod().getConstructorOrMethod().getName() + "failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info("Test -  " + result.getMethod().getConstructorOrMethod().getName() + "skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
