package cs147.exhibyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        img1.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" + question.getArtworks().get(0)
                , null, null));
        if(question.getArtworks().size() > 1) {
            ImageView img2 = findViewById(R.id.giveImage2);
            img2.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" + question.getArtworks().get(1)
                    , null, null));
        } else {
            CardView card2 = findViewById(R.id.giveCard2);
            card2.setVisibility(View.GONE);
        }
    }



}
