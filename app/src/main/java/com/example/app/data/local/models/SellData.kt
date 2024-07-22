package es.paytef.cepsastandalone.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.paytef.cepsastandalone.BuildConfig.DB_SELLS_NAME
import es.paytef.cepsastandalone.data.remote.models.request.CardInformation
import es.paytef.cepsastandalone.data.remote.models.request.Receipts
import es.paytef.cepsastandalone.data.remote.models.request.Timestamp

@Entity(tableName = DB_SELLS_NAME)
data class SellData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "time") var time: String? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "productID") val productID: String? = null,
    @ColumnInfo(name = "imageB64") val imageB64: String? = null,
    @ColumnInfo(name = "taxPercent") val taxPercent: String? = null,
    @ColumnInfo(name = "flagID") val flagID: String? = null,
    @ColumnInfo(name = "accepted") val accepted: Int? = null,
    @ColumnInfo(name = "code") val code: Int? = null,
    @ColumnInfo(name = "paytefUnit") val paytefUnit: String? = null,
    @ColumnInfo(name = "maxPrice") val maxPrice: String? = null,
    @ColumnInfo(name = "minPrice") val minPrice: String? = null,
    @ColumnInfo(name = "amountSell") val amountSell: String? = null,
    @ColumnInfo(name = "quantity") var quantity: String? = null,
    @ColumnInfo(name = "unitPrice") var unitPrice: String? = null,
    @ColumnInfo(name = "totalPrice") var totalPrice: String? = null,
    @ColumnInfo(name = "type_sell") val type_sell: String? = null,
    @ColumnInfo(name = "type_product") val type_product: String? = null,
    @ColumnInfo(name = "product_price") val product_price: String? = null,
    @ColumnInfo(name = "processorTextValue") val processorTextValue: String?,
    @ColumnInfo(name = "acquirerID") val acquirerID: String? = null,
    @ColumnInfo(name = "amountWithSign") val amountWithSign: String? = null,
    @ColumnInfo(name = "approved") val approved: Int? = null,
    @ColumnInfo(name = "authorisationCode") val authorisationCode: String? = null,
    @ColumnInfo(name = "authorisationMode") val authorisationMode: String? = null,
    @ColumnInfo(name = "commerceCSB") val commerceCSB: String? = null,
    @ColumnInfo(name = "commerceCode") val commerceCode: String? = null,
    @ColumnInfo(name = "commerceText") val commerceText: String? = null,
    @ColumnInfo(name = "emvARC") val emvARC: String? = null,
    @ColumnInfo(name = "failed") val failed: Int? = null,
    @ColumnInfo(name = "isDCC") val isDCC: Int? = null,
    @ColumnInfo(name = "message") val message: String? = null,
    @ColumnInfo(name = "needsSignature") val needsSignature: Int? = null,
    @ColumnInfo(name = "opType") val opType: String? = null,
    @ColumnInfo(name = "operationCommission") val operationCommission: Int? = null,
    @ColumnInfo(name = "operationTypeName") val operationTypeName: String? = null,
    @ColumnInfo(name = "paytefOperationNumber") val paytefOperationNumber: Long? = null,
    @ColumnInfo(name = "pinpadSerialNumber") val pinpadSerialNumber: String? = null,
    @ColumnInfo(name = "requestedAmount") val requestedAmount: Int? = null,
    @ColumnInfo(name = "resultCode") val resultCode: String? = null,
    @ColumnInfo(name = "resultText") val resultText: String? = null,
    @ColumnInfo(name = "sessionDate") val sessionDate: String? = null,
    @ColumnInfo(name = "signatureData") val signatureData: String? = null,
    @ColumnInfo(name = "signatureType") val signatureType: String? = null,
    @ColumnInfo(name = "tcod") val tcod: String? = null,
    @ColumnInfo(name = "timestamp") val timestamp: String?,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "transactionReference") val transactionReference: String? = null,
    @ColumnInfo(name = "verificationMode") val verificationMode: String? = null,
)