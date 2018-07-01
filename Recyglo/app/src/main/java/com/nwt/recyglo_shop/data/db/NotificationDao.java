package com.nwt.recyglo_shop.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

import java.util.List;

@Dao
public interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertNotifications(NotificationVO... notificationVOS);

    @Query("SELECT * FROM " + DatabaseConstants.NOTIFICATION_TABLE_NAME + " WHERE mId = :id LIMIT 1")
    NotificationVO getNotificationVOByNotificationNo(String id);

    @Query("SELECT * FROM " + DatabaseConstants.NOTIFICATION_TABLE_NAME+" WHERE visible = 'v' ")
    LiveData<List<NotificationVO>> getAllNotifications();

    @Query("UPDATE "+DatabaseConstants.NOTIFICATION_TABLE_NAME+" SET visible = :updateValue WHERE mId = :id ")
    void updateNotificationsById(String id,String updateValue);


    @Query("DELETE FROM " + DatabaseConstants.NOTIFICATION_TABLE_NAME)
    void deleteNotifications();

}
