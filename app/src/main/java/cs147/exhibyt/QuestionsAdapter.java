package cs147.exhibyt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Christina on 11/27/2018.
 * Kudos for
 * http://4dev.tech/2015/10/android-tutorial-creating-a-custom-listview-with-imageviews-and-textviews/
 * for their help!
 */

public class QuestionsAdapter extends ArrayAdapter<Question> {

    int resource;
    String response;
    Context context;

    public QuestionsAdapter(Context context, int resource, List<Question> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View qView, ViewGroup parent) {
        LinearLayout qsView;
        Question q = getItem(position);
        if (qView == null) {
            qsView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, qsView, true);
        } else {
            qsView = (LinearLayout) qView;
        }
        TextView curr = (TextView) qsView.findViewById(R.id.qText);
        curr.setText(q.getQText());
        return qsView;
    }
}
