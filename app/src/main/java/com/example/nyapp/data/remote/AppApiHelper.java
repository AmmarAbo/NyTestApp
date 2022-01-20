package com.example.nyapp.data.remote;
import com.example.nyapp.data.model.ApiResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import okhttp3.MultipartBody;

@Singleton
public class AppApiHelper implements ApiHelper {
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public Single<ApiResponse> doGetArticlesl(String section, String period) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOSTVVIEWED_ARTICLE)
                .addPathParameter("section", String.valueOf(section))
                .addPathParameter("period", String.valueOf(period))
                .addQueryParameter("api-key","NWMe05EL30UXHFHopGAuRXUaF96vTG8z")
                .build()
                .getObjectSingle(ApiResponse.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
