package com.example.nyapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyapp.R;
import com.example.nyapp.ViewModelProviderFactory;
import com.example.nyapp.data.model.ArticlesResponse;
import com.example.nyapp.databinding.FragmentHomeBinding;
import com.example.nyapp.ui.base.BaseFragment;
import com.example.nyapp.ui.home.article.ArticleAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> implements HomeFragmentNavigation{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    @Inject
    ViewModelProviderFactory factory;
    private ShimmerFrameLayout mShimmerViewContainer;
    @Inject
    LinearLayoutManager articleLimearLayoutManager;
    @Inject
    ArticleAdapter articleAdapter;
    @Override
    public int getBindingVariable() {
        return com.example.nyapp.BR.vm;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        homeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel.class);
        return homeViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
//        mFragmentHomeBinding.setVm(homeViewModel);
        setUp();
    }

    private void setUp() {

        mShimmerViewContainer=binding.shimmerViewContainer;
        mShimmerViewContainer.startShimmerAnimation();

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel.setNavigator(this);


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void FetchArticlesData(List<ArticlesResponse> ArtclesList) {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
        articleAdapter=new ArticleAdapter(ArtclesList);
        articleLimearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.articleRecyclerView.setLayoutManager(articleLimearLayoutManager);
        binding.articleRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public void handleError(Throwable throwable) {

    }
}