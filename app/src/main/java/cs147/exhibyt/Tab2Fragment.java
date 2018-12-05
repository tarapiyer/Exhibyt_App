package cs147.exhibyt;

/**
 * Created by Tara on 11/28/2018.
 *
 * Code taken from https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
 */

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View currView = inflater.inflate(R.layout.fragment_2, container, false);

        DataSingleton ds = DataSingleton.getInstance();

        ArrayList<Question> Qarray = new ArrayList<>();


        ArrayList<String> onlyPlane = new ArrayList<>();
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
        Qarray.add(new Question("What is scary?", multiple, responseArr));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?", onlyPlane));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?", multiple));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?", onlyPlane));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?", multiple));
        Qarray.add(new Question("What is scary?", onlyPlane));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?", multiple));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?", onlyPlane));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Mooing here"));

        ds.setQuestionList(Qarray);

        ListView Qlist = (ListView) currView.findViewById(R.id.listofQs);
        QuestionsAdapter adapter = new QuestionsAdapter(
                getActivity(),
                R.layout.question_view,
                Qarray);
        Qlist.setAdapter(adapter);

        Qlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked perform some action...
                Intent myIntent = new Intent(getContext(), ViewQuestionActivity.class);
                DataSingleton ds = DataSingleton.getInstance();
                ArrayList<Question> currList = ds.getQuestionList();
                Question curr = currList.get(position);
                myIntent.putExtra("QUESTION_ID", curr.getId());
                startActivity(myIntent);
            }
        });

        return currView;
    }
}