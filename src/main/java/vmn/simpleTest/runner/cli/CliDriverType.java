package vmn.simpleTest.runner.cli;

import org.apache.commons.cli.Option;

import vmn.simpleTest.driverType.DriverTypes;

public class CliDriverType {

	public String[] getDefaultValue() {
		return new String[] { DriverTypes.IPHONE.getDriverType()};
	}

	public Option getOption() {
		return new Option("driver", "driverType", true, "Driver type for using");
	}

	public void parse(String[] arg0) {
		CliOption.getInstance().setDriverTypes(DriverTypes.valueOf(arg0[0].toUpperCase()));
	}

}
