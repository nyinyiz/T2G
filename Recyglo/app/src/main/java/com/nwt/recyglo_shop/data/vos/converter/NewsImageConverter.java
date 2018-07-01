package com.nwt.recyglo_shop.data.vos.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nwt.recyglo_shop.data.vos.Image;

import java.util.List;

/**
 * Created by sherly on 3/3/18.
 */

public class NewsImageConverter {

    @TypeConverter
    public String listToString(Image tags) {
        Gson gson = new Gson();
        return gson.toJson(tags);
    }

    @TypeConverter
    public Image stringToList(String tagStr) {
        return new Gson().fromJson(tagStr, new TypeToken<Image>() {
        }.getType());
    }
}
