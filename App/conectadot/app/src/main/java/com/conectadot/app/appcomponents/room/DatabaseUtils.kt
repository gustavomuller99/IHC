package com.conectadot.app.appcomponents.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseUtils {

    fun loginUser(context: Context, email: String, password: String): Boolean {
        val users = AppDatabase.getDatabase(context).userDao().getAll()
        return users.any { it.email == email && it.password == password }
    }

    fun loginShelter(context: Context, email: String, password: String): Boolean {
        val shelters = AppDatabase.getDatabase(context).shelterDao().getAll()
        return shelters.any { it.email == email && it.password == password }
    }

    fun addUser(context: Context, user: User) {
        AppDatabase.getDatabase(context).userDao().insertAll(user)
    }

    fun addShelter(context: Context, shelter: Shelter) {
        AppDatabase.getDatabase(context).shelterDao().insertAll(shelter)
    }
}

@Database(entities = [User::class, Shelter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shelterDao(): ShelterDao

    abstract fun animalDao(): AnimalDao

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
