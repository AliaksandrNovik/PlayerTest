package vmn.simpleTest.constant.capability;

import vmn.simpleTest.utils.PropertyUtils;

/**
 * Created by Aliaksandr_Novik2 on 16.07.15.
 */
public class AndroidCapability {

	public static final String DEVICE_NAME = "Selendroid";

	public static final String PLATFORM_NAME = "Android";

	public static final String AUTOMATION_NAME = "Selendroid";

	public static final String UDID = PropertyUtils.getInstance().getProperties("udid");

}
