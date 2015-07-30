package vmn.simpleTest.driverType;

public enum DriverTypes {

    FIREFOX("firefox"), SAUCE("sauce"), IE("iexplore"), CHROME("googlechrome"), SAFARI("safari"), REMOTE("remote"), ANDROID_PHONE(
            "android_phone"), ANDROID_TABLET("android_tablet"), IPHONE("iphone"), IPAD("ipad"),
    ANDROID_PHONE_SELENDROID("android_phone_selendroid"), ANDROID_PHONE_WEB("android_phone_web"), ANDROID_PHONE_ROBOTIUM("android_phone_robotium");

    private String driverType;

    DriverTypes(String driverType) {
        this.driverType = driverType;
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

    public String getDriverType() {
        return driverType;
    }
}
