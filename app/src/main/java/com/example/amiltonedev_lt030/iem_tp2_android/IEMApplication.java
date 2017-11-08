package com.example.amiltonedev_lt030.iem_tp2_android;

import android.app.Application;

import com.example.amiltonedev_lt030.iem_tp2_android.manager.BLEManager;

/**
 * Created by amiltonedev_lt030 on 19/10/2017.
 */

public class IEMApplication extends Application {
    // Variable privée qui retiendra l'instance de l'objet application
    private static IEMApplication application;

    // getter public pour récupérer l'instance statique de l'objet application
    public static IEMApplication application() {
        return application;
    }

    // Variable privée qui retiendra la seule instance du manager
    private BLEManager bleManager;

    // getter public pour récupérer l'instance unique de l'objet manager
    public BLEManager getBleManager() {
        return bleManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        this.bleManager = new BLEManager();
    }
}
