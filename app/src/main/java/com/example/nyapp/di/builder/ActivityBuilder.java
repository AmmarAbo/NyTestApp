package com.example.nyapp.di.builder;
import com.example.nyapp.MainActivity;
import com.example.nyapp.ui.home.HomeFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public  abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = { HomeFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
