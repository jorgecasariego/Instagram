package androidatc.instagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import androidatc.instagram.R;
import androidatc.instagram.Utils.SectionsStatePagerAdapter;

/**
 * Created by jorgecasariego on 27/7/17.
 */

public class AccountSettingActivity extends AppCompatActivity {
    private static final String TAG = "AccountSettingActivity";
    private Context mContext;

    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        mContext = AccountSettingActivity.this;
        Log.d(TAG, "onCreate: started");

        viewPager = (ViewPager) findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        setupFragments();

        setupSettingsList();

        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating back to ProfileActivity");
                finish();
            }
        });
    }

    private void setupFragments() {
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));

    }

    private void setViewPager(int fragmentNumber) {
        mRelativeLayout.setVisibility(View.GONE);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList(){
        Log.d(TAG, "setupSettingsList:  initializing account setting list");

        ListView listView = (ListView) findViewById(R.id.listViewAccoutSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                setViewPager(position);
            }
        });
    }
}
