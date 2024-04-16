package com.thoughtworks.androidtrain.androidassignment.data.dao

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.google.gson.annotations.SerializedName
import com.thoughtworks.androidtrain.androidassignment.data.utils.PermissionUtil
import com.thoughtworks.androidtrain.model.dao.Comment
import com.thoughtworks.androidtrain.model.dao.Image
import com.thoughtworks.androidtrain.model.dao.Sender

@Entity
data class Tweet(
    @ColumnInfo var content: String?,
    @ColumnInfo var images: List<Image>?,
    @ColumnInfo var sender: Sender?,
    @ColumnInfo var comments: List<Comment>?,
    @ColumnInfo var error: String?,
    @ColumnInfo @SerializedName("unknown error") var unknownError: String?,
    @ColumnInfo var date: String?,
) {
    @PrimaryKey
    @ColumnInfo
    var id: String = ""

    override fun toString(): String {
        return "content $content \n"
    }

    fun isValid(): Boolean = error.isNullOrEmpty() && unknownError.isNullOrEmpty()

    fun generateAndBindId() {
        this.id = PermissionUtil().md5(sender?.nick + date)
    }
}


@Dao
interface TweetDao {
    @Query("SELECT * FROM tweet")
    fun getAll(): LiveData<List<Tweet>>

    @Query("SELECT * FROM tweet WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<Tweet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tweets: List<Tweet>)

    @Delete
    fun delete(tweet: Tweet)
}