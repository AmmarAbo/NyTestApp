package com.example.nyapp;

import com.example.nyapp.data.DataManager;
import com.example.nyapp.ui.base.BaseViewModel;
import com.example.nyapp.utils.rx.SchedulerProvider;

public class MainActivityViewModel extends BaseViewModel {
    public MainActivityViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
