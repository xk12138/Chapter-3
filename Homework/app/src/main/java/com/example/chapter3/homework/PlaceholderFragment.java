package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ListView listView;
    private AnimatorSet animatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.animation_view);
        listView = view.findViewById(R.id.list_view);
        animationView.playAnimation();
        animationView.setRepeatCount(-1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,
                        "alpha", 1f, 0f);
                animator1.setRepeatCount(0);
                animator1.setDuration(5000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView,
                        "alpha", 0f, 1f);
                animator2.setRepeatCount(0);
                animator2.setDuration(5000);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1, animator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
