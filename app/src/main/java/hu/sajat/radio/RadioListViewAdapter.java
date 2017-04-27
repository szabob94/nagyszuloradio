package hu.sajat.radio;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RadioListViewAdapter extends ArrayAdapter<RadioEntity> {
    private List<RadioEntity> radioEntities;
    private Context context;

    public RadioListViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<RadioEntity> objects) {
        super(context, resource, objects);
        this.context = context;
        this.radioEntities = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RadioEntity radioEntity = radioEntities.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_item_radio, null);
        ImageView radioIcon = (ImageView) view.findViewById(R.id.listview_item_radio_icon);
        TextView radioName = (TextView) view.findViewById(R.id.listview_item_radio_name);
        radioIcon.setImageResource(radioEntity.getIconResource());
        radioName.setText(radioEntity.getName());

        return view;
    }

    @Override
    public int getCount() {
        if (radioEntities != null)
            return radioEntities.size();
        return 0;
    }
}
