package androidatc.instagram.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidatc.instagram.Home.HomeActivity;
import androidatc.instagram.Likes.LikesActivity;
import androidatc.instagram.Profile.ProfileActivity;
import androidatc.instagram.R;
import androidatc.instagram.Search.SearchActivity;
import androidatc.instagram.Share.ShareActivity;

/**
 * Created by jorgecasariego on 25/7/17.
 *
 * Ya que vamos a utilizar esto en muchos lugares estamos haciendo este Helper para que cualquier
 * actividad del Navigation View pueda usar directamente
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class); // ACTIVITY_NUMBER = 0
                        context.startActivity(intent1);
                        break;
                    case  R.id.ic_search:
                        Intent intent2 = new Intent(context, SearchActivity.class); // ACTIVITY_NUMBER = 1
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_circle:
                        Intent intent3 = new Intent(context, ShareActivity.class); // ACTIVITY_NUMBER = 2
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_alert:
                        Intent intent4 = new Intent(context, LikesActivity.class); // ACTIVITY_NUMBER = 3
                        context.startActivity(intent4);
                        break;
                    case R.id.ic_android:
                        Intent intent5 = new Intent(context, ProfileActivity.class); // ACTIVITY_NUMBER = 3
                        context.startActivity(intent5);
                        break;
                }

                return false;
            }
        });
    }
}
