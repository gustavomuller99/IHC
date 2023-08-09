package com.conectadot.app.appcomponents.room

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(indices = [Index(value = ["email"], unique = true)])
data class Shelter(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "state") val state: String?,
    @ColumnInfo(name = "city") val city: String?,
)

@Dao
interface ShelterDao {
    @Query("SELECT * FROM shelter")
    fun getAll(): List<Shelter>

    @Query("SELECT * FROM shelter WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Shelter

    @Insert
    fun insertAll(vararg shelters: Shelter)

    @Delete
    fun delete(shelter: Shelter)
}