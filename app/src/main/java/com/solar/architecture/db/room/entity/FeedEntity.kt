package com.solar.architecture.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feeds")
data class FeedEntity(
    @ColumnInfo(name = "thumbnail")
    val thumbnail: Int,
    @ColumnInfo(name = "nickname")
    val nickname: String,
    @ColumnInfo(name = "title")
    val title: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
)