package com.conectadot.app.appcomponents.room

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class Animal(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "species") val species: String?,
    @ColumnInfo(name = "race") val race: String?,
    @ColumnInfo(name = "age") val age: String?,
    @ColumnInfo(name = "size") val size: String?,
    @ColumnInfo(name = "detailsc") val detailsc: String?,
    @ColumnInfo(name = "detailsv") val detailsv: String?,
    @ColumnInfo(name = "shelter") val shelter: String?
    )

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal")
    fun getAll(): List<Animal>

    @Query("SELECT * FROM animal WHERE name LIKE :name")
    fun findByName(name: String): Animal

    @Query("SELECT * FROM animal WHERE shelter LIKE :shelter")
    fun findByShelter(shelter: String): Animal
    
    @Insert
    fun insertAll(vararg animals: Animal)

    @Delete
    fun delete(animal: Animal)
}