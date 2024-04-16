package com.thoughtworks.androidtrain.model.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class Image(
    @ColumnInfo var url: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int=0
}


@Dao
interface ImageDao {
    @Query("SELECT * FROM image")
    fun getAll(): List<Image>

    @Insert
    fun insertAll(image: List<Image>)

}