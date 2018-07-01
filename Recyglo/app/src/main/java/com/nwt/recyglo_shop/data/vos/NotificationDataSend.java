package com.nwt.recyglo_shop.data.vos;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class NotificationDataSend {

    public String name;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public NotificationDataSend() {
    }

    public NotificationDataSend(String name) {
        this.name = name;
    }



}
