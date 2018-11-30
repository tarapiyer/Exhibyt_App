package cs147.exhibyt;

import java.util.ArrayList;

/**
 * Created by Tara on 11/24/2018.
 */

public class Question {
    private String questionText;
    private ArrayList<Response> responses;
    private ArrayList<String> imageNames;

    // There should be a list of images
    // There should also be an id

    public Question(String questionText) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = new ArrayList<>();
    }

    public Question(String questionText, ArrayList<String> imageNames) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = imageNames;
    }

    public String getQText(){
        return this.questionText;
    }

    public ArrayList<Response> getResponses() {
        return this.responses;
    }

    public ArrayList<String> getArtworks(){
        return this.imageNames;
    }
}
