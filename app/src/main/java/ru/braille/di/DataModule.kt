package ru.braille.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.braille.data.repository.LessonRepositoryImpl
import ru.braille.data.repository.SymbolRepositoryImpl
import ru.braille.data.room.DataBase
import ru.braille.data.room.InitializeDB
import ru.braille.domain.repository.LessonRepository
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application): DataBase {
        return Room.databaseBuilder(
            app,
            DataBase::class.java,
            DataBase.DB_NAME
        ).addCallback(InitializeDB()).build()
    }

    @Provides
    @Singleton
    fun provideLessonRepository(db: DataBase) : LessonRepository {
        return LessonRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideSymbolRepository(db: DataBase) : SymbolRepository {
        return SymbolRepositoryImpl(db.dao)
    }
}