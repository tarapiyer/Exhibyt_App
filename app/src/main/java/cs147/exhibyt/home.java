package cs147.exhibyt;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {


    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View currView = inflater.inflate(R.layout.fragment_home, container, false);

        DataSingleton ds = DataSingleton.getInstance();

        ArrayList<Question> Qarray = ds.getQuestionList();//new ArrayList<>();



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



        TextView numQs = (TextView) currView.findViewById(R.id.numQs);
        numQs.setText(Integer.toString(Qarray.size()) + " Questions");

        if (Qarray.size() == 0) {
            System.out.println("It's not working  ");
            FrameLayout background = (FrameLayout) currView.findViewById(R.id.critiqueBackgrd);
            int id = getResources().getIdentifier("cs147.exhibyt:drawable/frame"
                    , null, null);
            background.setBackgroundResource(id);
        } else {

            boolean firstTime = false;
            if (Qarray.size() == 1) {
                firstTime = true;
            }

            /* Add the first question:*/
// Start with the picture
            /*ArrayList<String> onlyPlane1 = new ArrayList<>();
            onlyPlane1.add("plane");

// Now working with the responses
            ArrayList<Response> place1ResponseArray = new ArrayList<>();
            place1ResponseArray.add(new Response("I love the colors used in the photo. The use of blue in clouds really makes the image pop.", 1, "Designer23"));
            place1ResponseArray.add(new Response("The small details on the plane are nice", 2, "Susy13"));
            place1ResponseArray.add(new Response("The fact that the palne isn't just a silouhette. The slight shading makes this work go to the next level.", 2, "Designer23"));

            Qarray.add(new Question("What is the best part of this picture?", onlyPlane1, place1ResponseArray));

            System.out.println("HOME");*/

            ListView Qlist = (ListView) currView.findViewById(R.id.listofQs);
            QuestionsAdapter adapter = new QuestionsAdapter(
                    getActivity(),
                    R.layout.question_view,
                    Qarray);
            Qlist.setAdapter(adapter);

            Qlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // When clicked perform some action...
                    Intent myIntent = new Intent(getActivity(), ViewQuestionActivity.class);
                    DataSingleton ds = DataSingleton.getInstance();
                    ArrayList<Question> currList = ds.getQuestionList();
                    Question curr = currList.get(position);
                    myIntent.putExtra("QUESTION_ID", curr.getId());
                    startActivity(myIntent);
                }
            });

            if (firstTime) {
                Toast.makeText(getActivity(), "Imagine that you have added 3 more questions and 3 days have passed. Review your feedback!",
                        Toast.LENGTH_LONG).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DataSingleton ds = DataSingleton.getInstance();
                        ArrayList<Question> Qarray = ds.getQuestionList();

// Going to simulate having a good time with adding responses and more questions with responses



                        ArrayList<Response> responseArray = new ArrayList<>();
                        responseArray.add(new Response("The Gourds of Order is an awesome name but the photo doesn't say \"Boo!\"", 1, "Designer23"));
                        responseArray.add(new Response("It's the day of the year in which you get the chance to create freaky art. Go darker!", 2, "Susy13"));
                        responseArray.add(new Response("Healthy, robust, constrasting. I like the pumpkin and think you should go with that. Also the dark bucket really stands out.", 2, "Designer23"));
                        responseArray.add(new Response("There are too many pumpkins and too few goblins.", 3, "UltimateMarker"));
                        responseArray.add(new Response("All the pumpkims are too orange. We need more diversity in colors here.", 4, "Susy13"));

                        Question newlyAddedQ = Qarray.get(0);
                        newlyAddedQ.setResponses(responseArray);

                        /* Add the first question:*/
// Start with the picture
                        ArrayList<String> onlyPlane = new ArrayList<>();
                        onlyPlane.add("plane");

// Now working with the responses
                        ArrayList<Response> placeResponseArray = new ArrayList<>();
                        placeResponseArray.add(new Response("I love the colors used in the photo. The use of blue in clouds really makes the image pop.", 1, "Designer23"));
                        placeResponseArray.add(new Response("The small details on the plane are nice", 2, "Susy13"));
                        placeResponseArray.add(new Response("The fact that the palne isn't just a silouhette. The slight shading makes this work go to the next level.", 2, "Designer23"));

                        Qarray.add(new Question("What is the best part of this picture?", onlyPlane, placeResponseArray));

                        /* Second question: */
// Do both at the same time
                        ArrayList<String> multiple = new ArrayList<>();
                        multiple.add("mask");
                        multiple.add("mask");

                        ArrayList<Response> multipleResponsesArray = new ArrayList<Response>();
                        multipleResponsesArray.add(new Response("I don't really see a difference between the two, but I love how the shadows of the eyes is a different shade from the drawn nose, highlighting how that part of the mask has been cut out of the mask.", 1, "Designer23"));
                        multipleResponsesArray.add(new Response("I don't get it. They're the same picture.", 2, "Susy13"));

                        Qarray.add(new Question("Which of these pieces are better?", multiple, multipleResponsesArray));

                        /* Third question: */

                        ArrayList<String> onlyPumpkim = new ArrayList<>();
                        onlyPumpkim.add("pumpkins");

                        ArrayList<Response> responseArr = new ArrayList<>();
                        responseArr.add(new Response("There are too many pumpkins and too few goblins.", 1, "UltimateMarker"));
                        responseArr.add(new Response("All the pumpkims are too orange. We need more diversity in colors here.", 2, "Susy13"));
                        responseArr.add(new Response("\tHeads up, this is going to be a very long comment.\n\t" +
                                "Before I talk about how to make this piece go to the next level, we need to see what this piece does well, and what it doesn't." +
                                "This piece does a wonderful job shading the pumpkins. Looking at each individual pumpkin, we see that the shading and coloring" +
                                "of each pumpkin is different, making looking at each pumpkin quite the pleasure. In addition, the use of almost complementary colors" +
                                "with the orange and green really make each other color pop in comparison. On the other hand, the relative monotony of the" +
                                "size of hte pumpkins makes it a little less interesting.\n\tHowever, I would say that the lack of focal point is the true area that" +
                                "could see massive improvement. These piece doesn't really have a focal point, so my eye ends up wandering around to figure out" +
                                "what exactly I should be focusing on within this piece.", 1, "Designer23"));


                        Qarray.add(new Question("How can I make this piece go to the next level?", onlyPumpkim, responseArr));

                        ds.setQuestionList(Qarray);

                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                    }
                }, 3000);

            }

            if (Qarray.size() == 4) {
                Toast.makeText(getActivity(), "Let's get started reviewing your feedback!",
                        Toast.LENGTH_LONG).show();
            }

            ds.setQuestionList(Qarray);
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

        FloatingActionButton b = (FloatingActionButton) currView.findViewById(R.id.floating_action_button);
        b.setOnClickListener(mButtonClickListener);
        return currView;
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            goToAddQs(v);
        }
    };

    public void goToAddQs(View v){
        Intent myIntent = new Intent(getActivity(), AddQuestionActivity.class);
        startActivity(myIntent);
    }


}
