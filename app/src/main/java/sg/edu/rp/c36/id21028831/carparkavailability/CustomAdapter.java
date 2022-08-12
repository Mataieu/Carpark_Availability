package sg.edu.rp.c36.id21028831.carparkavailability;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Availability> availabilityList;

    public CustomAdapter(Context context, int resource, ArrayList<Availability> objects){
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        availabilityList=objects;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(layout_id, parent, false);
        TextView tvTotalLots=rowView.findViewById(R.id.tvTotalLots);
        TextView tvLotsType=rowView.findViewById(R.id.tvLotsType);
        TextView tvLotsAvailable=rowView.findViewById(R.id.tvLotsAvailable);

        Availability currentItem=availabilityList.get(position);
        tvTotalLots.setText(currentItem.getTotal_lots());
        tvLotsType.setText(currentItem.getLot_type());
        tvLotsAvailable.setText(currentItem.getLots_available());

        return rowView;

    }
}
