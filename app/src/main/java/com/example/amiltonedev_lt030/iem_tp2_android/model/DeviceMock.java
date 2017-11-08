package com.example.amiltonedev_lt030.iem_tp2_android.model;

/**
 * Created by amiltonedev_lt030 on 19/10/2017.
 */

public class DeviceMock implements Device {
    @Override
    public int getHeartRate() {
        return 70;
    }

    @Override
    public int getBloodPressure() {
        return 25;
    }

    @Override
    public String getDeviceName() {
        return "MockedDevice";
    }
}
