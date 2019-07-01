package com.example.samplearchitectureforyou.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.foryou_1.ForYouModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(ForYouModel::class), version = 7)
public abstract class ForYouDatabase : RoomDatabase() {

    abstract fun forYouDao(): ForYouDao

    companion object {
        @Volatile
        private var INSTANCE: ForYouDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ForYouDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ForYouDatabase::class.java,
                    "For_You_Database"
                ).fallbackToDestructiveMigration()
                    .addCallback(ForYouDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class ForYouDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.forYouDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(wordDao: ForYouDao) {
            //wordDao.deleteAll()

            /* var word = Word("Hello")
             wordDao.insert(word)
             word = Word("World!")
             wordDao.insert(word)*/
        }
    }
}
