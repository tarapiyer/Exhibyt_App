package cs147.exhibyt;

/**
 * Created by Tara on 11/28/2018.
 *
 * Source for code: https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactQuestionsTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_questions_fragment, container, false);
    }
}
