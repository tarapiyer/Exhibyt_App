package cs147.exhibyt;

import java.util.ArrayList;
import java.util.Date;

import static android.icu.lang.UCharacter.toLowerCase;
import static android.icu.lang.UCharacter.toUpperCase;

/**
 * Created by Tara on 11/24/2018.
 */

public class Question {

    private String questionText;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public static String convertPicNameToDrawableName (String picName){
        return toLowerCase(picName.replaceAll(" ", "_"));
    }

    public static String convertDrawableNameToPicName (String drawableName){
        String temp = drawableName.replaceAll("_", " ");
        String[] splited = temp.split("\\s+");
        String res = "";
        for (String s : splited) {
            res = res + (char) toUpperCase(s.charAt(0));
            res = res + s.substring(1) + " ";
        }
        return res.substring(0, res.length()-1);
    }

    public Question() {
        this.questionText = "";
        // username of size 0 is the main user.
        this.userName = "";
        this.responses = new ArrayList<>();
        this.imageNames = new ArrayList<>();
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText) {
        this.userName = "";
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = new ArrayList<>();
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText, ArrayList<String> imageNames) {
        this.userName = "";
        this.questionText = questionText;
        this.responses = new ArrayList<>();
        this.imageNames = imageNames;
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText, ArrayList<String> imageNames, ArrayList<Response> responses) {
        this.userName = "";
        this.questionText = questionText;
        this.responses = responses;
        this.imageNames = imageNames;
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public Question(String questionText, ArrayList<String> imageNames, ArrayList<Response> responses, String userName) {
        this.userName = userName;
        this.questionText = questionText;
        this.responses = responses;

        this.imageNames = imageNames;
        Date date = new Date();
        this.id = questionText + Long.toString(date.getTime());
    }

    public void addNewResponse(String commentText, String userName){
        long currTime = 0;
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
