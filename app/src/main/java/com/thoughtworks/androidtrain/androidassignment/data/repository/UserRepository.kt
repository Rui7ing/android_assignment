package com.thoughtworks.androidtrain.androidassignment.data.repository

import androidx.lifecycle.LiveData
import com.thoughtworks.androidtrain.androidassignment.data.api.Api
import com.thoughtworks.androidtrain.androidassignment.data.dao.User
import com.thoughtworks.androidtrain.androidassignment.data.dao.UserDao

class UserRepository(private val userDao: UserDao) {
    fun fetchUsers(): LiveData<List<User>> = userDao.getAll()

    suspend fun saveFromRemote(): User? {
        val user = Api.fetchUsers() ?: return null
        user.generateAndBindId()
        userDao.insertAll(user)
        return user
    }
}