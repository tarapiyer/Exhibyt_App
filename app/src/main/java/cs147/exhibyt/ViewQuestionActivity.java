package cs147.exhibyt;

import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;

import androidx.appcompat.app.AppCompatActivity;

import static android.icu.lang.UCharacter.toLowerCase;

public class ViewQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_question);

        DataSingleton ds = DataSingleton.getInstance();
        ArrayList Qs = ds.getQuestionList();
        Iterator qIter = Qs.iterator();
        Question qDet = new Question();
        while (qIter.hasNext()) {
            Question curr = (Question) qIter.next();
            if (curr.getId().equals(getIntent().getStringExtra("QUESTION_ID"))) {
                qDet = curr;
                break;
            }
        }

        setTitle("Question Details");

        TextView qTitle = (TextView) findViewById(R.id.questionText);
        qTitle.setText(qDet.getQText());

        ArrayList<String> listOfPics = qDet.getArtworks();

        //LinearLayout picList = (LinearLayout) findViewById(R.id.pictureList);


        HorizontalScrollView scrollView = (HorizontalScrollView) findViewById(R.id.pictureList);
        LinearLayout topLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutItem);
        topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        for (int i = 0; i < listOfPics.size(); i++) {
            System.out.println("Let's try!");
            String q = listOfPics.get(i);
            final ImageView currImg = new ImageView (this);

            //imageView.setTag(i);
            int id = getResources().getIdentifier("cs147.exhibyt:drawable/" + toLowerCase(q)
                    , null, null);
            currImg.setTag("MOo");
            currImg.setImageResource(id);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(15, 15, 15, 15);
            currImg.setLayoutParams(lp);

            topLinearLayout.addView(currImg);

            currImg.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    // TODO Auto-generated method stub
                    Log.e("Tag",""+currImg.getTag());
                }
            });
        }


        /*ArrayList<Response> responseArray = new ArrayList<>();
        responseArray.add(new Response("The Gourds of Order is an awesome name but the photo doesn't say \"Boo!\"", 1, "Designer23"));
        responseArray.add(new Response("It's the day of the year in which you get the chance to create freaky art. Go darker!", 2, "Susy13"));
        responseArray.add(new Response("Healthy, robust, constrasting. I like the pumpkin and think you should go with that. Also the dark bucket really stands out.", 2, "Designer23"));
        responseArray.add(new Response("There are too many pumpkins and too few goblins.", 3, "UltimateMarker"));
        responseArray.add(new Response("All the pumpkims are too orange. We need more diversity in colors here.", 4, "Susy13"));*/

        ArrayList<Response> responseArray = qDet.getResponses();

        if (responseArray.size() == 0) {
            TextView noRespNotfi = (TextView) findViewById(R.id.noResponses);
            noRespNotfi.setVisibility(View.VISIBLE);
        }

        ListView Qlist = (ListView) findViewById(R.id.listofResponses);
        ResponsesAdapter adapter = new ResponsesAdapter(
                this,
                R.layout.individual_response,
                responseArray);
        Qlist.setAdapter(adapter);


    }

}
