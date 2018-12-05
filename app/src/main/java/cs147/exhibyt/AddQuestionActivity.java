package cs147.exhibyt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

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

        //See if plane image selected
        ImageView curr = (ImageView) findViewById(R.id.planeImage);
        if (curr.getAlpha() == 1) imgs.add("plane");

        //See if
        curr = (ImageView) findViewById(R.id.planeImage);
        if (curr.getAlpha() == 1) imgs.add("plane");
        curr = (ImageView) findViewById(R.id.planeImage);
        if (curr.getAlpha() == 1) imgs.add("plane");
        curr = (ImageView) findViewById(R.id.planeImage);
        if (curr.getAlpha() == 1) imgs.add("plane");

        Question newQ = new Question();

        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
