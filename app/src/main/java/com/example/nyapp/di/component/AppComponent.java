package com.example.nyapp.di.component;

import android.app.Application;

import com.example.nyapp.NyApp;
import com.example.nyapp.di.builder.ActivityBuilder;
import com.example.nyapp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(NyApp app);

    @Component.Builder

    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
