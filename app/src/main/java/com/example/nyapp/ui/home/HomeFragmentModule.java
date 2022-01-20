package com.example.nyapp.ui.home;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nyapp.ui.home.article.ArticleAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    ArticleAdapter provideArticleAdapter() {
        return new ArticleAdapter(new ArrayList());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(HomeFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}