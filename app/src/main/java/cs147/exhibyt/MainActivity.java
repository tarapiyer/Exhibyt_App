package cs147.exhibyt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


/**
 * MainActivity is the "My Gallery" screen that users see
 * upon first opening the Exhibyt app. In future, we may
 * need to update this to implement login.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
