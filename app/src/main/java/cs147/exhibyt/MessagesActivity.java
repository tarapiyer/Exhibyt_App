package cs147.exhibyt;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.icu.lang.UCharacter.toLowerCase;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        DataSingleton ds = DataSingleton.getInstance();



        ArrayList<Message> Qarray = new ArrayList<>();
        Qarray.add(new Message("Hi! Are you interested in joining my exhibition on the 24th at Santa Monica?", true));
        Qarray.add(new Message("Hi! Are you interested in joining my exhibition on the 24th at Santa Monica?", false));

        LinearLayout topLinearLayout = (LinearLayout) findViewById(R.id.listOfMessages);
        topLinearLayout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < Qarray.size(); i++) {
            Message q = Qarray.get(i);
            View date = new View(this);
            //date.setLayou

        }


        /*

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
         */

    }


}
