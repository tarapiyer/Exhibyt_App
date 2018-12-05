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
        questionList = new ArrayList<>();
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    private ArrayList<Question> questionList;


}
