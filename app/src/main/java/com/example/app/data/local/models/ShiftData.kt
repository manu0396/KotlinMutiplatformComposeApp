package es.paytef.cepsastandalone.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.paytef.cepsastandalone.BuildConfig.DB_SHIFT_NAME

@Entity(tableName = DB_SHIFT_NAME)
data class ShiftData(
    @PrimaryKey(autoGenerate = false) val id: Int = 1,
    @ColumnInfo(name = "idShift") val idShift: String? = "",
    @ColumnInfo(name = "checkInDate") val checkInDate: String,
    @ColumnInfo(name = "virtualTicket") val virtualTicket: Int? = 1 //Keep as 1 or 0
)
