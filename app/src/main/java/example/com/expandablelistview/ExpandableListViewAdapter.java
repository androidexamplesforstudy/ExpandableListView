package example.com.expandablelistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BloodyFire on 01.01.2017.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String [] groupNames = {"Sniadanie", "Przekąska", "Obiad", "Podwieczorek", "Kolacja"};
    String [][] childNames = {{"Omlet", "Owoce"}, {"Paluszki", "Pomarańcza"}, {"Kurczak","Ryż"}, {"Ciasto czekoladowe"}, {"Ryba"}};

    Context context;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return childNames[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return groupNames[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return childNames[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) { // zwraca groupView jakie ma się wyświetlić dla każdej grupy - można samemu stworzyć widok
        TextView textView = new TextView(context);
        textView.setText(groupNames[i]);
        textView.setPadding(150, 0, 15, 15 );
        textView.setTextSize(20);
        return textView;
    }
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final TextView textView = new TextView(context);
        textView.setText(childNames[i][i1]);
        textView.setTextSize(16);
        textView.setPadding(250,0,15,15);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, textView.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        return textView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
