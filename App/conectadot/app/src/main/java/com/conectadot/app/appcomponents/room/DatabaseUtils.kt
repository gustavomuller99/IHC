package com.conectadot.app.appcomponents.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DatabaseUtils {

    fun loginUser(context: Context, email: String, password: String): Boolean {
        val users = AppDatabase.getDatabase(context).userDao().getAll()
        return users.any { it.email == email && it.password == password }
    }

    fun loginShelter(): Boolean {
        return false
    }

    fun addUser(context: Context, user: User) {
        CoroutineScope(Dispatchers.Default).launch {
            AppDatabase.getDatabase(context).userDao().insertAll(user)
        }
    }
}

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            ).build().also { instance = it }
        }
    }
}
