package cs147.exhibyt;

import java.util.ArrayList;

/**
 * Created by Christina on 12/3/2018.
 */

class DataSingleton {
    private static final DataSingleton ourInstance = new DataSingleton();

    static DataSingleton getInstance() {
        return ourInstance;
    }

    public static DataSingleton getOurInstance() {
        return ourInstance;
    }

    private DataSingleton() {
        questionList = new ArrayList<Question>();
        otherUsersQuestions = new ArrayList<Question>();
        messages = new ArrayList<Message>();
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public ArrayList<Question> getOtherUsersQuestions() {
        return otherUsersQuestions;
    }

    public void setOtherUsersQuestions(ArrayList<Question> otherUsersQuestions) {
        this.otherUsersQuestions = otherUsersQuestions;
    }



    private ArrayList<Question> questionList;

    private ArrayList<Question> otherUsersQuestions;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    private ArrayList<Message> messages;



}
