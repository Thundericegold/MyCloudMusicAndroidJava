package com.ixuea.courses.mymusic.component.feed.fragment;

import android.os.Bundle;

import com.ixuea.courses.mymusic.databinding.FragmentFeedBinding;
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment;

/**
 * 首页-动态界面
 */
public class FeedFragment extends BaseViewModelFragment<FragmentFeedBinding> {
    public static FeedFragment newInstance() {

        Bundle args = new Bundle();

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
