package com.example.locadora.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImagePageAdapter extends PagerAdapter {

    private Context context;
    private int[] imagens;
    private ViewPager viewPager;
    private Handler handler;
    private Runnable runnable;

    public ImagePageAdapter(Context context, int[] imagens, ViewPager viewPager) {
        this.context = context;
        this.imagens = imagens;
        this.viewPager = viewPager;

        setupAutoScroll();
    }

    private void setupAutoScroll() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int imgAtual = viewPager.getCurrentItem();
                int proximaImg = imgAtual + 1;
                if (proximaImg >= getCount()) {
                    proximaImg = 0;
                }
                viewPager.setCurrentItem(proximaImg, true);
                handler.postDelayed(this, 2500);

            }
        };
    }

    private void startAutoScroll() {
        stopAutoScroll();
        handler.postDelayed(runnable, 2500);
    }

    private void stopAutoScroll() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        /*if (handler != null) {
            handler.removeCallbacks(runnable);
            if (position == getCount() - 1) {
                handler.postDelayed(runnable, 1000);
            }*/
        if(position == 0){
            startAutoScroll();
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imagens[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        container.addView(imageView);


        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

}
