/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nwt.recyglo_shop.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.data.vos.WastItemVO;
import com.nwt.recyglo_shop.data.vos.converter.NewsImageConverter;
import com.nwt.recyglo_shop.data.vos.converter.PickUpConverter;


@Database(entities = {UserVO.class, WastItemVO.class, NewsVO.class, ShopsVO.class, NotificationVO.class}, version = 4, exportSchema = false)
@TypeConverters({PickUpConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "RECYGLO.DB";

    private static AppDatabase INSTANCE;

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract UserDao userDao();
    public abstract WastDao wastDao();
    public abstract NewsDao newsDao();
    public abstract ShopDao shopDao();
    public abstract NotificationDao notificationDao();


}