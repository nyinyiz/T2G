package com.nwt.recyglo_shop.data.vos.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nwt.recyglo_shop.data.vos.PicketVO;
import com.nwt.recyglo_shop.data.vos.Voucherlist;

import java.util.List;

public class VoucherListConverter {

    @TypeConverter
    public String listToString(List<Voucherlist> tags) {
        Gson gson = new Gson();
        return gson.toJson(tags);
    }

    @TypeConverter
    public List<Voucherlist> stringToList(String tagStr) {
        return new Gson().fromJson(tagStr, new TypeToken<List<Voucherlist>>() {
        }.getType());
    }
}
