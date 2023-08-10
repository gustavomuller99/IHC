package com.conectadot.app.appcomponents.room

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "sender") val sender: Int?,
    @ColumnInfo(name = "receiver") val receiver: Int?,
    @ColumnInfo(name = "timestamp") val timestamp: String?,
    @ColumnInfo(name = "content") val content: String?
    )

@Dao
interface MessageDao {
    @Query("SELECT * FROM message")
        fun getAll(): List<Message>

    @Query("SELECT * FROM message WHERE sender LIKE :sender")
    fun getAllBySender(sender: String): List<Message>

    @Query("SELECT * FROM message WHERE sender LIKE :receiver")
    fun getAllByReceiver(receiver: String): List<Message>
    
    @Insert
    fun addMessage(vararg message: Message)

    @Delete
    fun deleteMessage(message: Message)
}