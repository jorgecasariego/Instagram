package androidatc.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidatc.instagram.R;
import androidatc.instagram.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUMBER = 4;

    private Context mContext = ProfileActivity.this;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);

        setupBottomNavigationView();
        setupToolBar();

    }

    private void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account setting");
                Intent intent = new Intent(mContext, AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Bottom Navigation View setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(this, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NUMBER);
        item.setChecked(true);
    }
}
