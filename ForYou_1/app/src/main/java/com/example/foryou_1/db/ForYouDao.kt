package com.example.samplearchitectureforyou.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foryou_1.ForYouModel

@Dao
interface ForYouDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    /*suspend*/ fun insert(forYouModel: ForYouModel)


    @Query("SELECT * FROM ForYouModel WHERE uid = :uid")//where clause
    fun loadForYouModelFromDb(uid: String): LiveData<ForYouModel>//dicey
}