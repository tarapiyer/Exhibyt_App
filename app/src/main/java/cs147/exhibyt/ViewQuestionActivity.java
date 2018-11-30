package cs147.exhibyt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question);

        setTitle("View Question");

        ArrayList<Response> responseArray = new ArrayList<>();
        responseArray.add(new Response("The Gourds of Order is an awesome name but the photo doesn't say \"Boo!\"", 1, "Designer23"));
        responseArray.add(new Response("It's the day of the year in which you get the chance to create freaky art. Go darker!", 2, "Susy13"));
        responseArray.add(new Response("Healthy, robust, constrasting. I like the pumpkin and think you should go with that. Also the dark bucket really stands out.", 2, "Designer23"));
        responseArray.add(new Response("There are too many pumpkins and too few goblins.", 3, "UltimateMarker"));

        ListView Qlist = (ListView) findViewById(R.id.listofResponses);
        ResponsesAdapter adapter = new ResponsesAdapter(
                this,
                R.layout.individual_response,
                responseArray);
        Qlist.setAdapter(adapter);


    }

}
