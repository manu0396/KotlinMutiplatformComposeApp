package es.paytef.cepsastandalone.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.paytef.cepsastandalone.BuildConfig.DB_PRODUCTS_NAME
import es.paytef.cepsastandalone.utils.Constants

@Entity(tableName = DB_PRODUCTS_NAME)
data class ProductData(
    @PrimaryKey(autoGenerate = false) val productID: String,
    @ColumnInfo(name = "time") val time: String? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "product_price") var product_price: String?,
    @ColumnInfo(name = "maxPrice") val maxPrice: String?,
    @ColumnInfo(name = "minPrice") val minPrice: String?,
    @ColumnInfo(name = "type_sell") val type_sell: String?,
    @ColumnInfo(name = "type_product") val type_product: String,
    @ColumnInfo(name = "imageB64") val imageB64: String?,
    @ColumnInfo(name = "taxPercent") val taxPercent: String,
    @ColumnInfo(name = "flagID") val flagID: String,
    @ColumnInfo(name = "accepted") val accepted: Int? = null,
    @ColumnInfo(name = "amountSell") val amountSell: String? = null,
    @ColumnInfo(name = "code") val  code: Int
)