package com.thoughtworks.androidtrain.model.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query


@Entity
data class Sender(
    @ColumnInfo var userName: String,
    @ColumnInfo var nick: String,
    @ColumnInfo var avatar: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int=0
}

@Dao
interface SenderDao {
    @Query("SELECT * FROM sender")
    fun getAll(): List<Sender>

    @Insert
    fun insertAll(senders: List<Sender>)

}