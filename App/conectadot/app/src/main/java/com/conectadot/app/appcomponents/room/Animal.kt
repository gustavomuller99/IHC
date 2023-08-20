package com.conectadot.app.appcomponents.room

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

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
    @ColumnInfo(name = "shelter") val shelter: Int?,
    @ColumnInfo(name = "image") val image: String?
    )

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal")
    fun getAll(): List<Animal>

    @Query("SELECT * FROM animal WHERE name LIKE :name")
    fun findByName(name: String): List<Animal>

    @Query("SELECT * FROM animal WHERE shelter LIKE :shelter")
    fun findByShelter(shelter: String): Animal

    @Query("UPDATE animal SET name = :name, species = :species, race = :race, age = :age, size = :size, detailsc = :detailsc, detailsv = :detailsv WHERE uid =:uid")
    fun update(uid: Int, name: String?, species: String?, race: String?, age: String?, size: String?, detailsc: String?, detailsv: String?)

    @Insert
    fun insertAll(vararg animals: Animal)

    @Delete
    fun delete(animal: Animal)
}