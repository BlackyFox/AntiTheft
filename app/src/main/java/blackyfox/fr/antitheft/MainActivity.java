package blackyfox.fr.antitheft;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.annotation.ColorRes;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment frag = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    frag = MenuFragment.newInstance(getString(R.string.title_home),getColorFromRes(R.color.colorPrimary));
                    if (frag != null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.container, frag, frag.getTag());
                        ft.commit();
                    }
                    return true;
                case R.id.navigation_settings:
                    //mTextMessage.setText(R.string.title_settings);
                    frag = MenuFragment.newInstance(getString(R.string.title_settings),getColorFromRes(R.color.colorPrimary));
                    if (frag != null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.container, frag, frag.getTag());
                        ft.commit();
                    }
                    return true;
                case R.id.navigation_infos:
                    //mTextMessage.setText(R.string.title_infos);
                    frag = MenuFragment.newInstance(getString(R.string.title_infos),getColorFromRes(R.color.colorPrimary));
                    if (frag != null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.container, frag, frag.getTag());
                        ft.commit();
                    }
                    return true;
            }
            return false;
        }
    };

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //mTextMessage = (TextView) findViewById(R.id.message);
        frag = MenuFragment.newInstance(getString(R.string.title_home),getColorFromRes(R.color.colorPrimary));
        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
