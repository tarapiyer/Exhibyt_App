package cs147.exhibyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class OtherPersonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_person_profile);
        TextView otherPersonName = findViewById(R.id.otherPersonName);
        TextView idText = findViewById(R.id.idText);
        ImageView profilePic = findViewById(R.id.OtherPersonProfilePic);
        DataSingleton ds = DataSingleton.getInstance();
        int id = Integer.parseInt(getIntent().getStringExtra("QUESTION_ID"));
        String userName = ds.getOtherUsersQuestions().get(id).getUserName();
        CardView card1 = findViewById(R.id.otherCard1);
        ImageView img1 = findViewById(R.id.otherImage1);
        TextView text1 = findViewById(R.id.otherText1);
        CardView card2 = findViewById(R.id.otherCard2);
        ImageView img2 = findViewById(R.id.otherImage2);
        TextView text2 = findViewById(R.id.otherText2);
        CardView card3 = findViewById(R.id.otherCard3);
        ImageView img3 = findViewById(R.id.otherImage3);
        TextView text3 = findViewById(R.id.otherText3);
        CardView card4 = findViewById(R.id.otherCard4);
        ImageView img4 = findViewById(R.id.otherImage4);
        TextView text4 = findViewById(R.id.otherText4);

        String about = "NOTGOOD";
        if(userName == "UltimateMaker") {
            about = "I’m Wilde. Artist by day. Critique by night. Reach out about collabs. I don’t bite. Usually";
            profilePic.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" + "ultimatemarker"
                    , null, null));
            card1.setVisibility(View.VISIBLE);
            img1.setImageResource(R.drawable.gushers);
            text1.setText("Gushers");

        } else if(userName == "Susy13"){
            about = "Art is life and I'm immortal. If you love art and want to buy, give me a chat!";
            profilePic.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" + "susy13"
                    , null, null));
            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            img1.setImageResource(R.drawable.fractal_kitty);
            text1.setText("Fractal Kitty");
            img2.setImageResource(R.drawable.pig_sloth);
            text2.setText("Pig Sloth");
            img3.setImageResource(R.drawable.blue_beauty);
            text3.setText("Blue Beauty");
        } else if (userName == "Designer23") {
            about = "Let us make art together. I am new but with practice I will be great. Join me!";
            profilePic.setImageResource(this.getResources().getIdentifier("cs147.exhibyt:drawable/" + "designer23"
                    , null, null));
            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            img1.setImageResource(R.drawable.fernssss);
            text1.setText("Fernssss");
            img2.setImageResource(R.drawable.rainbow_blast);
            text2.setText("Rainbow Blast");
            img3.setImageResource(R.drawable.handprints);
            text3.setText("Handprints");
            img4.setImageResource(R.drawable.orange_blossom);
            text4.setText("Orange Blossom");


        }

        idText.setText(about);
        otherPersonName.setText(userName);
    }



}
