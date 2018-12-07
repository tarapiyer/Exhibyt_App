package cs147.exhibyt;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.icu.lang.UCharacter.toLowerCase;


/**
 * A simple {@link Fragment} subclass.
 */
public class explore_feed extends Fragment {


    public explore_feed() {
        // Required empty public constructor
    }

    View explore_feed_view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        explore_feed_view = inflater.inflate(R.layout.fragment_explore_feed, container, false);
        return explore_feed_view;
    }


}
