package com.nwt.recyglo_shop.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

public class AlertDialogUtils {

    public static void showAlertDialog(Context context,String title,String message,String ok , String cancel) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);

        if (!title.equals("")) {
            builder1.setTitle(title);
        }
        builder1.setMessage(message);

        builder1.setCancelable(true);

        if (!ok.equals("")) {
            builder1.setPositiveButton(
                    ok,
                    (dialog, id) ->
                            dialog.cancel()
            );
        }

        if (!cancel.equals("")) {
            builder1.setNegativeButton(
                    cancel, (dialog, id) -> dialog.cancel()
            );
        }

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public static void showAlertDialogwithAction(Context context, String title, String message, String ok , String cancel, Intent okIntent,Intent cancelIntent) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);

        if (!title.equals("")) {
            builder1.setTitle(title);
        }
        builder1.setMessage(message);

        builder1.setCancelable(true);

        if (!ok.equals("")) {
            builder1.setPositiveButton(
                    ok,
                    (dialog, id) -> {
                        context.startActivity(okIntent);
                        dialog.cancel();

                    }
            );
        }

        if (!cancel.equals("")) {
            builder1.setNegativeButton(
                    cancel, (dialog, id) -> {
                        context.startActivity(cancelIntent);
                        dialog.cancel();

                    }
            );
        }

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


}
