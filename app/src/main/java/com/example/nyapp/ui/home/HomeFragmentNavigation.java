package com.example.nyapp.ui.home;
import com.example.nyapp.data.model.ApiResponse;
import com.example.nyapp.data.model.ArticlesResponse;


import java.util.List;

public interface HomeFragmentNavigation {

    void FetchArticlesData(List<ArticlesResponse> ArtclesList);
    void handleError (Throwable throwable);

}
