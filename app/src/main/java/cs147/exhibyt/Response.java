package cs147.exhibyt;

/**
 * Created by Tara on 11/24/2018.
 */

public class Response {
    private String text;
    private long time;
    //TODO: The user will have to change
    private String user;
    // TODO: Pictures attached to the comment

    public Response(String commentText, long time, String user) {
        this.text = commentText;
        this.time = time;
        this.user = user;
    }

    public long getTime() {
        long currTime = System.currentTimeMillis();
        return time;
    }

    public String getCommentText() {
        return text;
    }

    public String getUsername() {
        return user;
    }

}
