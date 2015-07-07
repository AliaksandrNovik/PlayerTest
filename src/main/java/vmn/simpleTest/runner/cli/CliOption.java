package vmn.simpleTest.runner.cli;

import vmn.simpleTest.driverType.DriverTypes;


public class CliOption {

	private static CliOption options = new CliOption();

	private DriverTypes driverType;

	public static CliOption getInstance() {
		return options;
	}

	public DriverTypes getDriverTypes() {
		return driverType;
	}

	public void setDriverTypes(DriverTypes driverType) {
		this.driverType = driverType;
	}
}
