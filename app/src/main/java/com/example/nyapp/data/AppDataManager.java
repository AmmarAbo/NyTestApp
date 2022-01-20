package com.example.nyapp.data;

import android.content.Context;

import com.example.nyapp.data.model.ApiResponse;
import com.example.nyapp.data.remote.ApiHeader;
import com.example.nyapp.data.remote.ApiHelper;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataManager implements DataManager{
    private final ApiHelper mApiHelper;
    private final Context mContext;
    @Inject
    public AppDataManager(Context context,ApiHelper apiHelper) {
        mContext = context;

        mApiHelper = apiHelper;

    }

    @Override
    public Single<ApiResponse> doGetArticlesl(String section, String period) {
        return mApiHelper.doGetArticlesl(section,period);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }
}
