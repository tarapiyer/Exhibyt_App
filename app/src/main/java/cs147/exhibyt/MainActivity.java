package cs147.exhibyt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


/**
 * MainActivity is the "My Gallery" screen that users see
 * upon first opening the Exhibyt app. In future, we may
 * need to update this to implement login.
 */

public class MainActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Artwork");
        adapter.addFragment(new Tab2Fragment(), "Questions");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void goToQuestions(View v){
        Intent myIntent = new Intent(this, MessagesActivity.class);
        startActivity(myIntent);
    }

    public void goToAddQs(View v){
        Intent myIntent = new Intent(this, AddQuestionActivity.class);
        startActivity(myIntent);
    }

    public void goToViewQ(View v){
        Intent myIntent = new Intent(this, ViewQuestionActivity.class);
        startActivity(myIntent);
    }
}
