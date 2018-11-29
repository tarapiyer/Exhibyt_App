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


        ArrayList<Response> responseArray = new ArrayList<>();
        responseArray.add(new Response("What is the best part of this picture?", 0, "telephone"));
        responseArray.add(new Response("What is the worst part of this picture?", 0, "telephone"));
        responseArray.add(new Response("What is scary?", 0, "telephone"));
        responseArray.add(new Response("What do you like about this picture?", 0, "telephone"));

        ListView Qlist = (ListView) findViewById(R.id.listofResponses);
        ResponsesAdapter adapter = new ResponsesAdapter(
                this,
                R.layout.individual_response,
                responseArray);
        Qlist.setAdapter(adapter);


    }

}
