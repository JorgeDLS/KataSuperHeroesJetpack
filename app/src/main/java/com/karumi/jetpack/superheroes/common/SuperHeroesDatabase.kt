package com.karumi.jetpack.superheroes.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.karumi.jetpack.superheroes.data.repository.room.SuperHeroDao
import com.karumi.jetpack.superheroes.data.repository.room.SuperHeroEntity

@Database(entities = [SuperHeroEntity::class], version = SuperHeroesDatabase.version)
abstract class SuperHeroesDatabase : RoomDatabase() {
    abstract fun superHeroesDao(): SuperHeroDao

    companion object {
        const val version = 1

        fun build(context: Context): SuperHeroesDatabase =
                Room.databaseBuilder(
                        context,
                        SuperHeroesDatabase::class.java,
                        "superheroes-db")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}