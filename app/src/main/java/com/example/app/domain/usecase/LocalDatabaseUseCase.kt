package com.example.app.domain.usecase

import android.content.Context
import com.example.app.R
import com.example.app.data.local.LocalDatabase
import com.example.app.utils.WrapperResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import es.paytef.cepsastandalone.data.local.models.ProductData
import es.paytef.cepsastandalone.data.local.models.RegistrationData
import es.paytef.cepsastandalone.data.local.models.SellData
import es.paytef.cepsastandalone.data.local.models.ShiftData
import javax.inject.Inject

@ActivityRetainedScoped
class LocalDatabaseUseCase @Inject constructor(private val db: LocalDatabase, @ApplicationContext val context: Context) {

    fun insertProduct(productData: ProductData): WrapperResponse<Long> {
        val response = try {
            db.dao().insertProduct(productData)
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }

    fun insertSell(sellData: SellData): WrapperResponse<Long> {
        val response = try {
            db.dao().insertSell(sellData)
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }

    fun getProductsBought(): WrapperResponse<List<ProductData>> {
        val resp = try {
            db.dao().getProductData()
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(resp)
    }

    fun getLocalSells(): WrapperResponse<List<SellData>> {
        val resp = try {
            db.dao().getLocalSells()
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(resp)
    }

    fun deleteProduct(name: String): WrapperResponse<Int> {
        val resp = try {
            db.dao().deleteProduct(name)
        } catch (e: java.lang.Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(resp)
    }

    fun getTcod(): WrapperResponse<String?> {
        val response = try {
            db.dao().getTcod()
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }

    fun getOpenShift(): WrapperResponse<ShiftData>{
        val response = try{
            db.dao().getOpenShift()
        }catch (e:Exception){
            return WrapperResponse.Error(e.message ?: context.getString(R.string.errGenericDB))
        }
        return WrapperResponse.Success(response)
    }

    fun insertShift(data: ShiftData):WrapperResponse<Long>{
        val response = try{
            db.dao().insertShiftData(data)
        }catch (e:Exception){
            return WrapperResponse.Error(e.message ?: context.getString(R.string.errGenericDB))
        }
        return WrapperResponse.Success(response)
    }

    fun insertTcod(tcod: String, sessionToken: String, macAddress:String, serialNumber: String, terminalName: String?): WrapperResponse<Long?> {
        val response = try {
            db.dao().insertTcod(
                RegistrationData(
                    tcod = tcod,
                    sessionToken = sessionToken,
                    mac_address = macAddress,
                    serial_number = serialNumber,
                    terminalName = terminalName
                )
            )
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }

    fun getSessionData(): WrapperResponse<RegistrationData?> {
        val response = try {
            db.dao().getSessionData()
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }

    fun deleteSessionId(token: String): WrapperResponse<Int?> {
        val response = try {
            db.dao().deleteSessionId(token)
        } catch (e: Exception) {
            return WrapperResponse.Error(e.message ?: e.stackTraceToString())
        }
        return WrapperResponse.Success(response)
    }
}