package com.example.nyapp.ui.home;

import androidx.databinding.ObservableArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nyapp.data.DataManager;
import com.example.nyapp.data.model.ArticlesResponse;
import com.example.nyapp.ui.base.BaseViewModel;
import com.example.nyapp.utils.rx.SchedulerProvider;

public class HomeViewModel extends BaseViewModel<HomeFragmentNavigation> {


    public final ObservableArrayList<ArticlesResponse> articlesResponses;

    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        articlesResponses= new ObservableArrayList();

        fetechArticles("all-sections","7");
    }

    public void fetechArticles(String sections,String period) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doGetArticlesl(sections,period)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(apiResponse -> {
                    if (apiResponse != null && apiResponse.getMessage().equals("OK")) {
                        articlesResponses.addAll(apiResponse.getResults());
                        getNavigator().FetchArticlesData(articlesResponses);
                        setIsLoading(false);
                    } else {
                        setIsLoading(false);
                    }

                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

}

