package com.thoughtworks.androidtrain.model.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class Comment(
    @ColumnInfo var content: String,
    @ColumnInfo var sender: Sender
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int=0
}

@Dao
interface CommentDao {
    @Query("SELECT * FROM comment")
    fun getAll(): List<Comment>

    @Insert
    fun insertAll(comments: List<Comment>)

}