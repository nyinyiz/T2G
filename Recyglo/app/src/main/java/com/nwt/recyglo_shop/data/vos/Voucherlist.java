
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.TypeConverters;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.data.vos.converter.ItemListConverter;
import com.nwt.recyglo_shop.data.vos.converter.PickUpConverter;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Voucherlist {

    @SerializedName("buyer_id")
    public Long buyer_id;

    @SerializedName("date")
    public String date;

    @SerializedName("id")
    public Long id;

    @SerializedName("item_list")
    @TypeConverters({ItemListConverter.class})
    public List<ItemList> item_list;

    @SerializedName("seller_id")
    public Long seller_id;

    @SerializedName("service_charges")
    public String service_charges;

}
