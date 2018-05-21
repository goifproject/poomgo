package kr.co.teaming.www.teaming.controller.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.co.teaming.www.teaming.controller.matching.main.MatchingFragment;
import kr.co.teaming.www.teaming.controller.message.main.MessageFragment;
import kr.co.teaming.www.teaming.controller.myStudy.main.MyStudyFragment;
import kr.co.teaming.www.teaming.controller.notice.main.NoticeFragment;
import kr.co.teaming.www.teaming.controller.study.main.StudyFragment;

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