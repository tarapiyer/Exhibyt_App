package cs147.exhibyt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.cardview.widget.CardView;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class GiveFeedback extends Activity {

    public String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getStringExtra("id");
        setContentView(R.layout.activity_give_feedback);

        TextView txt = findViewById(R.id.giveQuestion);

        DataSingleton ds = DataSingleton.getInstance();
        ArrayList<Question> questions = ds.getOtherUsersQuestions();
        Question question = questions.get(Integer.parseInt(id));

        txt.setText( questions.get(Integer.parseInt(id)).getQText());

        ImageView img1 = findViewById(R.id.giveImage1);
        img1.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" +
                        Question.convertPicNameToDrawableName(question.getArtworks().get(0))
                , null, null));

        TextView caption1 = (TextView) findViewById(R.id.caption1);
        caption1.setText(Question.convertDrawableNameToPicName(question.getArtworks().get(0)));

        if(question.getArtworks().size() > 1) {
            ImageView img2 = findViewById(R.id.giveImage2);
            img2.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" +
                            Question.convertPicNameToDrawableName(question.getArtworks().get(1))
                    , null, null));

            TextView caption2 = (TextView) findViewById(R.id.caption2);
            caption2.setText(Question.convertDrawableNameToPicName(question.getArtworks().get(1)));
        } else {
            CardView card2 = findViewById(R.id.giveCard2);
            card2.setVisibility(View.GONE);
        }


    }

    public void submitFeedback(View v) {
        TextView txt = (TextView) findViewById(R.id.textComment);


        String qText = txt.getText().toString();
        if (qText.length() == 0) {
            //This was giving me errors so I commented it out. Christina can you check this out when
            //you get the chance
            TextView errorMessage = findViewById(R.id.showGiveFeedbackErrors);
            errorMessage.setText("ERROR: You provide feedback to see others'.");
            errorMessage.setTextColor(Color.RED);
            errorMessage.setVisibility(View.VISIBLE);
            return;
        }


        id = getIntent().getStringExtra("id");
        DataSingleton ds = DataSingleton.getInstance();
        ArrayList<Question> questions = ds.getOtherUsersQuestions();
        Question question = questions.get(Integer.parseInt(id));
        question.addNewResponse(txt.getText().toString(), "Me");

        Intent myIntent = new Intent(this, ViewQuestionActivity.class);
        myIntent.putExtra("QUESTION_ID", id);
        startActivity(myIntent);
        //Moo
    }



}
