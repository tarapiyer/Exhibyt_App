package cs147.exhibyt;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Kudos to https://developer.android.com/reference/android/support/design/widget/FloatingActionButton
        // for its help
        /*FloatingActionButton fab = findViewById(R.id.addQ);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("SUCCESSFUL!");
            }
        });*/



        ArrayList<Question> Qarray = new ArrayList<>();
        Question q = new Question("What is the best part of this picture?");
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        setTitle("Messages");
        ListView Qlist = (ListView) findViewById(R.id.listofQs);
        QuestionsAdapter adapter = new QuestionsAdapter(
                this,
                R.layout.question_view,
                Qarray);
        Qlist.setAdapter(adapter);
    }


}
