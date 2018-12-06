package cs147.exhibyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * MainActivity is the "My Gallery" screen that users see
 * upon first opening the Exhibyt app. In future, we may
 * need to update this to implement login.
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //View currView = inflater.inflate(R.layout.fragment_2, container, false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.id.myTitle);


        DataSingleton ds = DataSingleton.getInstance();

        ArrayList<Question> Qarray = ds.getQuestionList();//new ArrayList<>();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.homeMNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, homeFragment).commit();




        /*ArrayList<String> onlyPlane = new ArrayList<>();
        onlyPlane.add("plane");

        ArrayList<String> multiple = new ArrayList<>();
        multiple.add("mask");
        multiple.add("mask");

        ArrayList<String> onlyPumpkim = new ArrayList<>();
        onlyPumpkim.add("pumpkins");


        ArrayList<Response> responseArray = new ArrayList<>();
        responseArray.add(new Response("The Gourds of Order is an awesome name but the photo doesn't say \"Boo!\"", 1, "Designer23"));
        responseArray.add(new Response("It's the day of the year in which you get the chance to create freaky art. Go darker!", 2, "Susy13"));
        responseArray.add(new Response("Healthy, robust, constrasting. I like the pumpkin and think you should go with that. Also the dark bucket really stands out.", 2, "Designer23"));
        responseArray.add(new Response("There are too many pumpkins and too few goblins.", 3, "UltimateMarker"));
        responseArray.add(new Response("All the pumpkims are too orange. We need more diversity in colors here.", 4, "Susy13"));

        ArrayList<Response> responseArr = new ArrayList<>();
        responseArr.add(new Response("The Gourds of Order is an awesome name but the photo doesn't say \"Boo!\"", 1, "Designer23"));
        responseArr.add(new Response("There are too many pumpkins and too few goblins.", 3, "UltimateMarker"));
        responseArr.add(new Response("All the pumpkims are too orange. We need more diversity in colors here.", 4, "Susy13"));

        Qarray.add(new Question("Which speaks to your inner goblin more?", onlyPumpkim, responseArray));
        Qarray.add(new Question("What is the best part of this picture?", onlyPlane, responseArr));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?", multiple, responseArr));*/

        /*ds.setQuestionList(Qarray);

        TextView numQs = (TextView) findViewById(R.id.numQs);
        numQs.setText(Integer.toString(Qarray.size()) + " Questions");

        if (Qarray.size() == 0) {
            System.out.println("It's not working :(");
            RelativeLayout background = (RelativeLayout) findViewById(R.id.critiqueBackgrd);
            int id = getResources().getIdentifier("cs147.exhibyt:drawable/frame"
                    , null, null);
            background.setBackgroundResource(id);
        } else {
            ListView Qlist = (ListView) findViewById(R.id.listofQs);
            QuestionsAdapter adapter = new QuestionsAdapter(
                    this,
                    R.layout.question_view,
                    Qarray);
            Qlist.setAdapter(adapter);

            Qlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // When clicked perform some action...
                    Intent myIntent = new Intent(getApplicationContext(), ViewQuestionActivity.class);
                    DataSingleton ds = DataSingleton.getInstance();
                    ArrayList<Question> currList = ds.getQuestionList();
                    Question curr = currList.get(position);
                    myIntent.putExtra("QUESTION_ID", curr.getId());
                    startActivity(myIntent);
                }
            });
        }
        //return currView;
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab2Fragment(), "Questions");
        adapter.addFragment(new Tab1Fragment(), "Artwork");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);*/
    }

    public void goToHome(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void goToMessages(View v){
        Intent myIntent = new Intent(this, MessagesActivity.class);
        startActivity(myIntent);
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

    public void goToAddQsNew(View v){
        Intent myIntent = new Intent(this, AddQuestionActivity.class);
        startActivity(myIntent);
    }

    public void goToExplore(View v){
        Intent myIntent = new Intent(this, GiveFeedback.class);
        startActivity(myIntent);
    }

    explore_feed explore_feedFragment = new explore_feed();
    home homeFragment = new home();
    allmessages allmessages = new allmessages();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.messagesMNav:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, allmessages).commit();
            case  R.id.homeMNav:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, homeFragment).commit();
                return true;
            case R.id.exploreMNav:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, explore_feedFragment).commit();
                return true;
        }


        return false;
    }
}
