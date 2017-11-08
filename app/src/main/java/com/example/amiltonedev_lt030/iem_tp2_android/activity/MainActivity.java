package com.example.amiltonedev_lt030.iem_tp2_android.activity;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.amiltonedev_lt030.iem_tp2_android.IEMApplication;
import com.example.amiltonedev_lt030.iem_tp2_android.R;
import com.example.amiltonedev_lt030.iem_tp2_android.model.Device;
import com.example.amiltonedev_lt030.iem_tp2_android.model.DeviceMock;
import com.example.amiltonedev_lt030.iem_tp2_android.manager.BLEManager;

public class MainActivity extends AppCompatActivity {

    // pour les propriétés graphiques sont toujours en private
    // le nom de la variable commence par le type de l'objet
    // puis on décrit à quoi il sert
    private Button buttonConnexion;
    private Button buttonOpenDetail;
    private Button buttonNameDevice;
    private TextView textViewStatus;
    private TextView textViewDeviceName;

    private BLEManager bleManager;

    /*
    Il est conseillé d'utiliser toujours le même ordre pour l'écriture des méthodes dans une clsse
    Particulierement dans les fragments & activité. Ici :

    Méthodes du cycle de vie
    Méthodes d'override d'hériatge
    Méthode publiques
    Méthodes privées
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // découpage de l'initialisation en méthodes
        initializeInjection();
        initViews();
    }

    private void connectDevice(){
        Device device = new DeviceMock();
        bleManager.pairDevice(device);

        if(bleManager.isThereDevicePaired()){
            textViewStatus.setText(getResources().getString(R.string.connexion_status_paired));
        }else{
            textViewStatus.setText(getResources().getString(R.string.connexion_status_none));
        }
    }

    private void openDetail(){
        Intent openDetailIntent = new Intent(this, DetailActivity.class);
        startActivity(openDetailIntent);
    }

    private void getDeviceName(){
        String deviceName = bleManager.getDeviceName();
        if (deviceName != null && !deviceName.isEmpty()){
            textViewDeviceName.setText(deviceName);
        }else{
            //textViewDeviceName.setText(getString(R.string.connexion_status_none));


            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Write your message here.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }


    private void initViews(){
        buttonConnexion = (Button)findViewById(R.id.main_button_connect);
        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectDevice();
            }
        });

        buttonOpenDetail = (Button)findViewById(R.id.main_button_open_detail);
        buttonOpenDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail();
            }
        });

        buttonNameDevice = (Button)findViewById(R.id.main_button_name_device);
        buttonNameDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDeviceName();
            }
        });

        textViewStatus = (TextView)findViewById(R.id.main_textviexw_connexion_status);
    }

    private void initializeInjection(){
        this.bleManager = IEMApplication.application().getBleManager();
    }
}
