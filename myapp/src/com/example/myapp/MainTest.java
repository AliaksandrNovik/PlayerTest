package com.example.myapp;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class MainTest extends ActivityInstrumentationTestCase2 {
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.timleg.egoTimer.preMain";

    private Solo solo;

    private PageIsoAndroid pageAndroid;

    @SuppressWarnings("unchecked")
    public MainTest(Class activityClass) throws ClassNotFoundException {
        super(Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME));
    }

    @Override
    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testCalendar() {
        pageAndroid = new PageIsoAndroid(solo);
        pageAndroid.clickOnButtonToDoList();
    }
}
