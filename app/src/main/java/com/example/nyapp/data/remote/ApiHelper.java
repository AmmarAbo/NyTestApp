package com.example.nyapp.data.remote;

import com.example.nyapp.data.model.ApiResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<ApiResponse> doGetArticlesl(String section,String period);
    ApiHeader getApiHeader();
}
