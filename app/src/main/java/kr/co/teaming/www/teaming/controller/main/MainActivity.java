package kr.co.teaming.www.teaming.controller.main;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.matching.main.MatchingFragment;
import kr.co.teaming.www.teaming.controller.message.main.MessageFragment;
import kr.co.teaming.www.teaming.controller.myStudy.main.MyStudyFragment;
import kr.co.teaming.www.teaming.controller.notice.main.NoticeFragment;
import kr.co.teaming.www.teaming.controller.study.main.StudyFragment;
import kr.co.teaming.www.teaming.custom.filterDialog.NormalFilterDialog;

// TODO 전체 스크롤에 뷰페이저 넘길 때 어색하다. 2-3번 하거나 신경을 써야 옆으로 넘어가짐
public class MainActivity extends AppCompatActivity implements
//        StudyFragment.OnStudyFragmentInteraction,
        MatchingFragment.OnFragmentInteractionListener,
        MyStudyFragment.OnFragmentInteractionListener,
        NoticeFragment.OnFragmentInteractionListener,
        MessageFragment.OnFragmentInteractionListener,
        NormalFilterDialog.OnNormalFilterDialogInteraction{

    private Fragment studyFragment, matchingFragment, myStudyFragment, noticeFragment, messageFragment = null;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * setViews
     */
    private void init() {
        initView();
        setToolbar();
        setTabLayout();
        setViewpager();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.container);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);

    }

    private void setTabLayout() {
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    // TODO 뭔가 이상한데, 왜 이렇게 툭툭 끊기지?
    private void setViewpager() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // TODO
//        mViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });

    }


    /**
     * editText lose focuse when touched outside
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if(v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if(!outRect.contains((int)ev.getRawX(), (int)ev.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public void onBackPressed() {
        ((StudyFragment) studyFragment).onBackPressed();
    }

    /**
     * Navigation
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //study
    }

    @Override
    public void setResult(int category, int region, int subRegion) {
        Toast.makeText(this, "[category]"+category+"[region]"+region+"[subRegion]"+subRegion, Toast.LENGTH_LONG).show();
    }

    class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            studyFragment = StudyFragment.newInstance("");
            matchingFragment = MatchingFragment.newInstance("param1", "param2");
            myStudyFragment = MyStudyFragment.newInstance("param1", "param2");
            noticeFragment = NoticeFragment.newInstance("param1", "param2");
            messageFragment = MessageFragment.newInstance("param1", "param2");
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = studyFragment;
                    break;
                case 1:
                    fragment = matchingFragment;
                    break;
                case 2:
                    fragment = myStudyFragment;
                    break;
                case 3:
                    fragment = noticeFragment;
                    break;
                case 4:
                    fragment = messageFragment;
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }

}
