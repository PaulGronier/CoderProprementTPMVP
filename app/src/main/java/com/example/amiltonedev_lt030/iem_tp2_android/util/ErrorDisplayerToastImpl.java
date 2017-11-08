package com.example.amiltonedev_lt030.iem_tp2_android.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.amiltonedev_lt030.iem_tp2_android.activity.MainActivity;

/**
 * Created by iem on 08/11/2017.
 */

public class ErrorDisplayerToastImpl extends AppCompatActivity implements ErrorDisplayer{
    private final Context context;

    public ErrorDisplayerToastImpl (Context context) {
        this.context = context;
    }

    @Override
    public void displayError(String errorMessage) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
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
