package cs147.exhibyt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class AddQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
    }

    public void changeOpacity(View v) {
        if (v.getAlpha() < 1f) {
            v.setAlpha(1);
        } else {
            v.setAlpha(.2f);
        }
    }



    // Here, we're submitting the app
    public void goToQuestionsN(View v) {
        DataSingleton ds = DataSingleton.getInstance();
        ArrayList<Question> qList = ds.getQuestionList();

        ArrayList<String> imgs = new ArrayList<>();

        //Check if there is a question
        TextView qTextView = findViewById(R.id.plain_text_input);
        String qText = qTextView.getText().toString();
        if (qText.length() == 0) {
            //This was giving me errors so I commented it out. Christina can you check this out when
            //you get the chance
            TextView errorMessage = findViewById(R.id.showQuestionErrors);
            errorMessage.setText("ERROR: You must have a question to receive feedback.");
            errorMessage.setTextColor(Color.RED);
            errorMessage.setVisibility(View.VISIBLE);
            return;
        }


        //See if plane image selected
        ImageView curr = (ImageView) findViewById(R.id.planeImage);
        if (curr.getAlpha() == 1) imgs.add("plane");

        //See if halloween image selected
        curr = (ImageView) findViewById(R.id.halloweenImage);
        if (curr.getAlpha() == 1) imgs.add("halloween");

        /*//See if mask image selected
        curr = (ImageView) findViewById(R.id.maskImage);
        if (curr.getAlpha() == 1) imgs.add("mask");

        //See if pumpkins image selected
        curr = (ImageView) findViewById(R.id.pumpkinImage);
        if (curr.getAlpha() == 1) imgs.add("pumpkins");*/

        Question newQ = new Question(qText, imgs);

        qList.add(0, newQ);
        System.out.println("Tried adding a question!");
        ds.setQuestionList(qList);


        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void addArtworkDialog(View v) {
        Toast.makeText(this, "This would allow for users to upload new pieces of art.",
                Toast.LENGTH_LONG).show();
    }
}
