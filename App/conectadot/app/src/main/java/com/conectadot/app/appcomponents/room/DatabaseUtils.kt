package com.conectadot.app.appcomponents.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.conectadot.app.modules.login.data.viewmodel.LoginResult

object DatabaseUtils {

    fun loginUser(context: Context, email: String, password: String): Int {
        val users = AppDatabase.getDatabase(context).userDao().getAll()
        return users.firstOrNull { it.email == email && it.password == password }?.uid ?: LoginResult.Failed.value
    }

    fun loginShelter(context: Context, email: String, password: String): Int {
        val shelters = AppDatabase.getDatabase(context).shelterDao().getAll()
        return shelters.firstOrNull { it.email == email && it.password == password }?.uid ?: LoginResult.Failed.value
    }

    fun getShelter(context: Context, id: Int?): Shelter? {
        val shelters = AppDatabase.getDatabase(context).shelterDao().getAll()
        return shelters.firstOrNull { it.uid == id }
    }

    fun addUser(context: Context, user: User) {
        AppDatabase.getDatabase(context).userDao().insertAll(user)
    }

    fun addShelter(context: Context, shelter: Shelter) {
        AppDatabase.getDatabase(context).shelterDao().insertAll(shelter)
    }

    fun addAnimal(context: Context, animal: Animal) {
        AppDatabase.getDatabase(context).animalDao().insertAll(animal)
    }

    fun updateAnimal(context: Context, animal: Animal, animalID: Int){
        AppDatabase.getDatabase(context).animalDao().update(animalID, animal.name, animal.species, animal.race, animal.age, animal.size, animal.detailsc, animal.detailsv)
    }

    fun addMessage(context: Context, message: Message) {
        AppDatabase.getDatabase(context).messageDao().addMessage(message)
    }

    fun getAnimalList(context: Context, user: Int): List<Animal> {
        return AppDatabase.getDatabase(context).animalDao().getAll().filter { it.shelter == user }
    }

    fun getAllAnimals(context: Context): List<Animal> {
        return AppDatabase.getDatabase(context).animalDao().getAll()
    }

    fun getAnimalDetails(context: Context, id: Int): Animal{
        return AppDatabase.getDatabase(context).animalDao().getAll().first { it.uid == id }
    }
}

@Database(entities = [User::class, Shelter::class, Animal::class, Message::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shelterDao(): ShelterDao

    abstract fun animalDao(): AnimalDao

    abstract fun messageDao(): MessageDao

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
