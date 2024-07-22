package com.example.app.domain.models


data class SellDomain(
    val productID: String? = null,
    val name: String? = null,
    var productPrice: String? = null,
    val maxPrice: String? = null,
    val minPrice: String? = null,
    val imageB64: String? = null,
    val taxPercent: String? =null,
    val flagID: String? = null,
    val acepted: Boolean? = null,
    var amountSell: String? = null,
    val code: Int? = null,
    val paytefUnit: String? = null,
    var quantity: String? = null,
    var unitPrice: String? = null,
    var totalPrice: String? = null,
    var time: String? = null,
    val type_sell: String? = null,
    val processorTextValue: String? = null,
    val type_product: String? = null,
    val acquirerID: String? = null,
    val amountWithSign: String? = null,
    val approved: Boolean? = null,
    val authorisationCode: String? = null,
    val authorisationMode: String? = null,
    val commerceCSB: String? = null,
    val commerceCode: String? = null,
    val commerceText: String? = null,
    val emvARC: String? = null,
    val failed: Boolean? = null,
    val isDCC: Boolean? = null,
    val message: String? = null,
    val needsSignature: Boolean? = null,
    val opType: String? = null,
    val operationCommission: Int? = null,
    val operationTypeName: String? = null,
    val paytefOperationNumber: Long? = null,
    val pinpadSerialNumber: String? = null,
    val requestedAmount: Int? = null,
    val resultCode: String? = null,
    val resultText: String? = null,
    val sessionDate: String? = null,
    val signatureData: String? = null,
    val signatureType: String? = null,
    val tcod: String? = null,
    val timestamp: String? = null,
    val title: String? = null,
    val transactionReference: String? = null,
    val verificationMode: String? = null
){
    //Add function over model if needed
}