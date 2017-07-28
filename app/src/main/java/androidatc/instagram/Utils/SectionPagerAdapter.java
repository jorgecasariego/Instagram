package androidatc.instagram.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgecasariego on 26/7/17.
 *
 * Class that store fragments for tabs
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "SectionPagerAdapter";
    private List<Fragment> mFragmentsList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmentsList.add(fragment);
    }
}
