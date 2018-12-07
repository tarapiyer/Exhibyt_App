package cs147.exhibyt;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

        ArrayList<Response> userArray = new ArrayList<Response>();
        userArray.add(new Response("Your request to connect has been sent.", 0, "Designer23"));
        userArray.add(new Response("Your request to connect has been sent.", 0, "Susy13"));
        userArray.add(new Response("Your request to connect has been sent.", 0, "UltimateMarker"));

        ListView Qlist = (ListView) currView.findViewById(R.id.listOfUsers);
        ResponsesAdapter adapter = new ResponsesAdapter(
                getContext(),
                R.layout.individual_response,
                userArray);
        Qlist.setAdapter(adapter);

        /*
        ArrayList<Response> responseArray = qDet.getResponses();

        if (responseArray.size() == 0) {
            TextView noRespNotfi = (TextView) findViewById(R.id.noResponses);
            noRespNotfi.setVisibility(View.VISIBLE);
        }

        ListView Qlist = (ListView) findViewById(R.id.listofResponses);
        ResponsesAdapter adapter = new ResponsesAdapter(
                this,
                R.layout.individual_response,
                responseArray);
        Qlist.setAdapter(adapter);
         */

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
