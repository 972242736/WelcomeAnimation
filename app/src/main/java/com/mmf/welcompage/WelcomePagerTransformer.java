package com.mmf.welcompage;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MMF on 2016/8/28.
 */
public class WelcomePagerTransformer implements ViewPager.PageTransformer {
    EnterListener enterListener;
    @Override
    public void transformPage(View view, float position) {
        if (position < 1 && position > -1) {
            //拿到所有的View
            ViewGroup rlGroup = (ViewGroup) view.findViewById(R.id.rl_group);
            for (int i = 0; i < rlGroup.getChildCount(); i++) {
                View child = rlGroup.getChildAt(i);
                //设置视差效果，给当前的view来个加速度
                float factor = (float) Math.random() * 2;
                if (child.getTag() == null) {
                    child.setTag(factor);
                } else {
                    factor = (float) child.getTag();
                }
                child.setTranslationX(position * factor * child.getWidth());
                //设置某个view的点击监听
                if(child.getId() == R.id.iv_enter){
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            enterListener.enter();
                        }
                    });
                }
            }
            //放大缩小
//            view.setScaleX(1-Math.abs(position));
//            view.setScaleY(1-Math.abs(position));
//            view.setScaleX(Math.max(0.9f,1-Math.abs(position)));
//            view.setScaleY(Math.max(0.9f,1-Math.abs(position)));
            //3D翻转
//            view.setPivotX(position < 0f ? view.getWidth() : 0f);
//            view.setRotationY(position * 90f);
            //3D内翻转
//            view.setPivotX(position < 0f ? view.getWidth() : 0f);
//            view.setPivotY(view.getHeight()*0.5f);
//            view.setRotationY(position * 60f);
            view.setTranslationX(position < 0 ?0f :-view.getWidth()*position);

        }

    }
    public interface EnterListener{
        void enter();
    }

    public EnterListener getEnterTest() {
        return enterListener;
    }

    public void setEnterTest(EnterListener enterListener) {
        this.enterListener = enterListener;
    }
}
