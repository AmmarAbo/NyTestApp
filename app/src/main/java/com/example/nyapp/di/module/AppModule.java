package com.example.nyapp.di.module;

import android.app.Application;
import android.content.Context;
import com.example.nyapp.data.AppDataManager;
import com.example.nyapp.data.DataManager;
import com.example.nyapp.data.remote.ApiHeader;
import com.example.nyapp.data.remote.ApiHelper;
import com.example.nyapp.data.remote.AppApiHelper;
import com.example.nyapp.utils.rx.AppSchedulerProvider;
import com.example.nyapp.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }






    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return (DataManager) appDataManager;
    }



    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader() {
        return new ApiHeader.ProtectedApiHeader();
    }


    @Provides
    @Singleton
    ApiHeader.PublicApiHeader providePublicApiHeader() {
        return new ApiHeader.PublicApiHeader();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
