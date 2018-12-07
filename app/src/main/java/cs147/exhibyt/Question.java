package cs147.exhibyt;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tara on 11/24/2018.
 */

public class Question {
    private String questionText;

    public void setResponses(ArrayList<Response> responses) {
        this.responses = responses;
    }

    private ArrayList<Response> responses;
    private ArrayList<String> imageNames;

    public String getId() {
        return id;
    }

    private String id;

    // There should be a list of images
    // There should also be an id

    public Question() {
        this.questionText = "";
        this.responses = new ArrayList<>();
        this.imageNames = new ArrayList<>();
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = new ArrayList<>();
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText, ArrayList<String> imageNames) {
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = imageNames;
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText, ArrayList<String> imageNames, ArrayList<Response> responses) {
        this.questionText = questionText;
        this.responses = responses;

        this.imageNames = imageNames;
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public void addNewResponse(String commentText, String userName){
        long currTime = System.currentTimeMillis();
        Response newResponse = new Response(commentText, currTime, userName);
        responses.add(0, newResponse);
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
