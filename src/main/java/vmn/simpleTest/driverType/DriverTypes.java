package vmn.simpleTest.driverType;

public enum DriverTypes {

	FIREFOX("firefox"), SAUCE("sauce"), IE("iexplore"), CHROME("googlechrome"), SAFARI("safari"), REMOTE("remote"), ANDROID_PHONE(
			"android_phone"), ANDROID_TABLET("android_tablet"), IPHONE("iphone"), IPAD("ipad");

	private String driverType;

	DriverTypes(String driverType) {
		this.driverType = driverType;
	}

	public String getDriverType() {
		return driverType;
	}

	public static DriverTypes getDriverType(String text) {
		if (text != null) {
			for (DriverTypes bt : DriverTypes.values()) {
				if (text.equalsIgnoreCase(bt.name())) {
					return bt;
				}
			}
		}
		return IPHONE;
	}
}
