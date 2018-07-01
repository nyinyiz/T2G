package com.nwt.recyglo_shop.data.vos.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nwt.recyglo_shop.data.vos.PicketVO;

import java.util.List;

public class PickUpConverter {

    @TypeConverter
    public String listToString(PicketVO tags) {
        Gson gson = new Gson();
        return gson.toJson(tags);
    }

    @TypeConverter
    public PicketVO stringToList(String tagStr) {
        return new Gson().fromJson(tagStr, new TypeToken<PicketVO>() {
        }.getType());
    }
}
