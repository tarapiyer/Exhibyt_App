package cs147.exhibyt;

/**
 * Created by Tara on 11/24/2018.
 */

public class Response {
    private String text;
    private int time;
    //TODO: The user will have to change
    private String user;
    // TODO: Pictures attached to the comment

    public Response(String commentText, int time, String user) {
        this.text = commentText;
        this.time = time;
        this.user = user;
    }

    public int getTime() {
        return time;
    }

    public String getCommentText() {
        return text;
    }

    public String getUsername() {
        return user;
    }

}
