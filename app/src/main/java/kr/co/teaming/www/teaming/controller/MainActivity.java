package kr.co.teaming.www.teaming.controller;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.matching.MatchingFragment;
import kr.co.teaming.www.teaming.controller.message.MessageFragment;
import kr.co.teaming.www.teaming.controller.myStudy.MyStudyFragment;
import kr.co.teaming.www.teaming.controller.notice.NoticeFragment;
import kr.co.teaming.www.teaming.controller.study.main.StudyFragment;

public class MainActivity extends AppCompatActivity implements
        MatchingFragment.OnFragmentInteractionListener,
        MyStudyFragment.OnFragmentInteractionListener,
        NoticeFragment.OnFragmentInteractionListener,
        MessageFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

//        TeamingRESTInterface request = TeamingApplication.getTeamingRESTInterface(); //
//        Call<StudyInfo> call = request.studyInfo();
//        call.enqueue(new Callback<StudyInfo>() { // callback 함수.
//            @Override
//            public void onResponse(Call<StudyInfo> call, Response<StudyInfo> response) {
//                if(response.code() >= 200 || response.code() <= 400){
//                    StudyInfo studyInfo = response.body();
//                    Toast.makeText(MainActivity.this, studyInfo.total+"", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StudyInfo> call, Throwable t) {
//
//            }
//        });
    }


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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //study
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = StudyFragment.newInstance("user");
                    break;
                case 1:
                    fragment = MatchingFragment.newInstance("param1", "param2");
                    break;
                case 2:
                    fragment = MyStudyFragment.newInstance("param1", "param2");
                    break;
                case 3:
                    fragment = NoticeFragment.newInstance("param1", "param2");
                    break;
                case 4:
                    fragment = MessageFragment.newInstance("param1", "param2");
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
