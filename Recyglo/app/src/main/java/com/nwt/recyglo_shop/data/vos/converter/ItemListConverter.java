package com.nwt.recyglo_shop.data.vos.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nwt.recyglo_shop.data.vos.ItemList;
import com.nwt.recyglo_shop.data.vos.Voucherlist;

import java.util.List;

public class ItemListConverter {

    @TypeConverter
    public String listToString(List<ItemList> tags) {
        Gson gson = new Gson();
        return gson.toJson(tags);
    }

    @TypeConverter
    public List<ItemList> stringToList(String tagStr) {
        return new Gson().fromJson(tagStr, new TypeToken<List<ItemList>>() {
        }.getType());
    }
}
