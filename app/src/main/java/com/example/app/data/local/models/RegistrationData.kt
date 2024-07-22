package es.paytef.cepsastandalone.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.paytef.cepsastandalone.BuildConfig.DB_SESSION_NAME

@Entity(tableName = DB_SESSION_NAME)
data class RegistrationData(
    @PrimaryKey(autoGenerate = false) val id: Int = 1,
    @ColumnInfo(name = "tcod") val tcod: String,
    @ColumnInfo(name = "sessionToken") val sessionToken: String,
    @ColumnInfo(name = "mac_address") val mac_address:String,
    @ColumnInfo(name = "serial_number") val serial_number: String,
    @ColumnInfo(name = "terminalName") val terminalName: String?
)