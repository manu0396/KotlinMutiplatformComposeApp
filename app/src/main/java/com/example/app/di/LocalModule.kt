package com.example.app.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.paytef.cepsastandalone.BuildConfig.DB_NAME
import com.example.app.data.local.RetailDAO
import com.example.app.data.local.LocalDatabase
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_10_11
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_1_2
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_2_3
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_3_4
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_4_5
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_5_6
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_6_7
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_7_8
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_8_9
import es.paytef.cepsastandalone.data.local.migrations.Migrations.MIGRATION_9_10
import es.paytef.cepsastandalone.domain.usecase.LocalDatabaseUseCase

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            DB_NAME
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9, MIGRATION_9_10, MIGRATION_10_11)
        .build()
    }

    @Provides
    @Singleton
    fun provideDao(localDatabase: LocalDatabase): RetailDAO {
        return localDatabase.dao()
    }

    @Provides
    @Singleton
    fun provideLocalDatabaseUseCase(@ApplicationContext context: Context): LocalDatabaseUseCase {
        return LocalDatabaseUseCase(provideDB(context), context = context)
    }

}