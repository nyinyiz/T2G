
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.data.vos.converter.PickUpConverter;
import com.nwt.recyglo_shop.data.vos.converter.VoucherListConverter;
import com.nwt.recyglo_shop.utils.DatabaseConstants;


@Entity(tableName = DatabaseConstants.SHOP_TABLE_NAME)
public class ShopsVO {

    @PrimaryKey(autoGenerate = true)
    public Long mId;

    @SerializedName("address")
    public String address;

    @SerializedName("id")
    public Long id;

    @SerializedName("shop_name")
    public String shop_name;

    @SerializedName("township")
    public String township;

    @SerializedName("township_tag")
    public String township_tag;

    @SerializedName("voucherlist")
    @TypeConverters({VoucherListConverter.class})
    public List<Voucherlist> voucherlist;

}
