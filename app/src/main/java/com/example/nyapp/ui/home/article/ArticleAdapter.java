package com.example.nyapp.ui.home.article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyapp.data.model.ArticlesResponse;
import com.example.nyapp.databinding.ArticleItemBinding;
import com.example.nyapp.ui.base.BaseViewHolder;

import java.util.List;

public class ArticleAdapter  extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_LOADING = 2;
    private List<ArticlesResponse> articlesResponses;
    int log=0;
    private boolean isLoaderVisible = false;
    public ArticleAdapter(List<ArticlesResponse> mealResponseList) {
        this.articlesResponses = mealResponseList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ArticleItemBinding itemMealMealsBinding = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new MealViewHolder(itemMealMealsBinding);

            case VIEW_TYPE_EMPTY:
            default:


                return null;
        }
    }


    @Override
    public int getItemCount() {
        if (articlesResponses != null && articlesResponses.size() > 0) {
            return articlesResponses.size();
        } else {
            return 1;
        }
    }
    public void setLog(int log){
        this.log=log;


    }
    @Override
    public int getItemViewType(int position) {
        if (articlesResponses != null && !articlesResponses.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }
    public void addLoading() {
        isLoaderVisible = true;
        articlesResponses.add(new ArticlesResponse());
        notifyItemInserted(articlesResponses.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = articlesResponses.size() - 1;
        ArticlesResponse item = getItem(position);
        if (item != null) {
            articlesResponses.remove(position);
            notifyItemRemoved(position);
        }
    }
    ArticlesResponse  getItem(int position) {
        return articlesResponses.get(position);
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    public void addItems(List<ArticlesResponse> articlesResponses) {
        this.articlesResponses.addAll(articlesResponses);
        notifyDataSetChanged();
    }

    public void clearItems() {
        articlesResponses.clear();
    }





    public class MealViewHolder extends BaseViewHolder implements  ArticlItemViewModel.ArticleItemViewModelListener {

        private ArticleItemBinding mBinding;

        private ArticlItemViewModel articlItemViewModel;
    ArticlesResponse response;

        public MealViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            response = articlesResponses.get(position);
            articlItemViewModel = new ArticlItemViewModel(response,this);
            mBinding.setViewModel(articlItemViewModel);
            mBinding.executePendingBindings();
        }






        @Override
        public void onItemClick() {

        }
    }


}
