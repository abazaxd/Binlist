package com.abaza_vg.binlist.data.di

import android.app.Application
import com.abaza_vg.binlist.data.CardInfoRepositoryImpl
import com.abaza_vg.binlist.data.retrofit.API
import com.abaza_vg.binlist.data.retrofit.RetrofitClient
import com.abaza_vg.binlist.data.room.AppDatabase
import com.abaza_vg.binlist.data.room.CardInfoDAO
import com.abaza_vg.binlist.domain.CardInfoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCardInfoRepository(impl: CardInfoRepositoryImpl): CardInfoRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideDao(
            application: Application
        ): CardInfoDAO {
            return AppDatabase.getInstance(application).cardInfoDao()
        }

        @ApplicationScope
        @Provides
        fun provideApi(): API {
            return RetrofitClient.getClient().create(API::class.java)
        }
    }
}