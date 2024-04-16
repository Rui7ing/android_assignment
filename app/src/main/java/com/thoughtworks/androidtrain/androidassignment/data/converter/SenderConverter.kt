package com.thoughtworks.androidtrain.androidassignment.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.thoughtworks.androidtrain.model.dao.Sender

class SenderConverter {

    @TypeConverter
    fun toSender(json: String?): Sender? {
        if (json == null) {
            return null
        }
        val type = object : TypeToken<Sender>(){}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(sender: Sender?): String? {
        val type = object: TypeToken<Sender>(){}.type
        return Gson().toJson(sender, type)
    }
}