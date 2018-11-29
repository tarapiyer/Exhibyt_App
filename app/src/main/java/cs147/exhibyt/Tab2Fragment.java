package cs147.exhibyt;

/**
 * Created by Tara on 11/28/2018.
 *
 * Code taken from https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View currView = inflater.inflate(R.layout.fragment_2, container, false);


        ArrayList<Question> Qarray = new ArrayList<>();
        Question q = new Question("What is the best part of this picture?");
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));
        Qarray.add(new Question("What is the best part of this picture?"));
        Qarray.add(new Question("What is the worst part of this picture?"));
        Qarray.add(new Question("What is scary?"));
        Qarray.add(new Question("What do you like about this picture?"));
        Qarray.add(new Question("Moo"));

        ListView Qlist = (ListView) currView.findViewById(R.id.listofQs);
        QuestionsAdapter adapter = new QuestionsAdapter(
                getActivity(),
                R.layout.question_view,
                Qarray);
        Qlist.setAdapter(adapter);

        return currView;
    }
}