
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

@Entity(tableName = DatabaseConstants.NOTIFICATION_TABLE_NAME)
public class NotificationVO {

    @PrimaryKey(autoGenerate = true)
    public Long mId;

    @SerializedName("isAccept")
    public String isAccept;

    @SerializedName("isReject")
    public String isReject;

    @SerializedName("notification_title")
    public String notification_title;

    @SerializedName("visible")
    public String visible;

}
