package kr.co.teaming.www.teaming.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ViewPageAwareScrollView extends ScrollView {

    private boolean mScrollable;
    private float startX, startY;
    private float curX, curY;

    public ViewPageAwareScrollView(Context context) {
        super(context);
    }

    public ViewPageAwareScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isScrollable() {
        return mScrollable;
    }

    public void setScrollable(boolean mScrollable) {
        this.mScrollable = mScrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getRawX();
                startY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                curX = ev.getRawX();
                curY = ev.getRawY();
                float disX = curX - startY;
                if(disX > 100)
                    return mScrollable = false;
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!isScrollable())
            return false;
        else
            return super.onInterceptTouchEvent(ev);
    }


}
