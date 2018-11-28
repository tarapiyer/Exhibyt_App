package cs147.exhibyt;

/**
 * Created by Tara on 11/24/2018.
 */

public class Question {
    private String questionText;
    // There should be a list of images
    // There should also be an id

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQText(){
        return this.questionText;
    }
}
