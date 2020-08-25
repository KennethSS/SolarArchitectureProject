package com.solar.architecture.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solar.architecture.db.room.entity.FeedEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface FeedDao : BaseDao<FeedEntity> {

    /**
     * Get a product by id.

     * @return the product from the table with a specific id.
     */
    @Query("SELECT * FROM Feeds WHERE id = :id")
    fun getFeedById(id: String): Flowable<FeedEntity>

    /**
     * Insert a product in the database. If the product already exists, replace it.

     * @param product the product to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeed(product: FeedEntity)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM Feeds")
    fun deleteAll()

    @Query("SELECT * FROM feeds")
    fun getAll(): Single<List<FeedEntity>>
}