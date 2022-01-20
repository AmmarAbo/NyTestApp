package com.example.nyapp.ui.home.article;

import androidx.databinding.ObservableField;

import com.example.nyapp.data.model.ArticlesResponse;

public class ArticlItemViewModel {
    ArticlesResponse articlesResponse;

    public final ObservableField<String> title;
    public final ObservableField<String> byline;
    public final ObservableField<String> createdDate;
    public final ArticleItemViewModelListener viewmodellistner;

    public ArticlItemViewModel(ArticlesResponse articlesResponse, ArticleItemViewModelListener listener) {


        this.viewmodellistner = listener;
        this.articlesResponse = articlesResponse;
        title = new ObservableField(articlesResponse.getTitle());
        byline = new ObservableField(String.valueOf(articlesResponse.getByline()));
        createdDate = new ObservableField(articlesResponse.getPublishedDate());

    }
    public void onItemClick() {
        viewmodellistner.onItemClick();
    }

    public interface ArticleItemViewModelListener {

        void onItemClick();
    }
}

