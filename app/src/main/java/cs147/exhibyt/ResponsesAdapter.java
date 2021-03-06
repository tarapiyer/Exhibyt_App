package cs147.exhibyt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.icu.lang.UCharacter.toLowerCase;

/**
 * Created by Christina on 11/27/2018.
 */

public class ResponsesAdapter extends ArrayAdapter {

    int resource;
    String resp;
    Context context;


    public ResponsesAdapter(Context context, int resource, List<Response> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View qView, ViewGroup parent) {
        LinearLayout qsView;
        Response q = (Response) getItem(position);
        if (qView == null) {
            qsView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, qsView, true);
        } else {
            qsView = (LinearLayout) qView;
        }
        TextView curr = (TextView) qsView.findViewById(R.id.commentText);
        curr.setText(q.getCommentText());
        curr = (TextView) qsView.findViewById(R.id.commentTime);
        curr.setText(Long.toString(q.getTime()) + " days");
        curr = (TextView) qsView.findViewById(R.id.userCommenting);
        curr.setText(q.getUsername());
        ImageView currImg = (ImageView) qsView.findViewById(R.id.profilePic);
        int id = getContext().getResources().getIdentifier("cs147.exhibyt:drawable/" + toLowerCase(q.getUsername())
                , null, null);
        currImg.setImageResource(id);
        return qsView;
        //Let's try now
    }
}
