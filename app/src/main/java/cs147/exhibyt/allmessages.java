package cs147.exhibyt;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class allmessages extends Fragment {


    public allmessages() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View currView = inflater.inflate(R.layout.fragment_allmessages, container, false);

        return currView;
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            goToMessages(v);
        }
    };

    public void goToMessages(View v){
        Intent myIntent = new Intent(getActivity(), MessagesActivity.class);
        startActivity(myIntent);
    }



}
