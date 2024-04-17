package com.thoughtworks.androidtrain.androidassignment.data.dao

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.google.gson.annotations.SerializedName
import com.thoughtworks.androidtrain.androidassignment.data.utils.PermissionUtil


@Entity
data class User(
    @ColumnInfo(name = "profile_image")@SerializedName("profile-image") var profileImage: String,
    @ColumnInfo var avatar: String,
    @ColumnInfo var nick: String,
    @ColumnInfo var username: String,
) {
    @PrimaryKey
    @ColumnInfo
    var id: String = ""


    fun generateAndBindId() {
        this.id = PermissionUtil().md5(nick + username)
    }
}


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: User)

}