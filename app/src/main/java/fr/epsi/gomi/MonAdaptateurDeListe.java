package fr.epsi.gomi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MonAdaptateurDeListe extends BaseAdapter {
    private final String[] values = new String[] { "verre", "emballage, papier et carton", "organique", "textile", "non recyclable"  };
    private final Integer[] tab_images_pour_la_liste = {
        R.drawable.tri_verre,
        R.drawable.tri_papier_cartons,
        R.drawable.tri_organique,
        R.drawable.tri_textile,
        R.drawable.non_recyclable
    };

    @Override
    public long getItemId(int position) {
        Log.v("ltm","getItemId("+position+")=");
        return tab_images_pour_la_liste[position];
    }


    @Override
    public Object getItem(int position) {
        Log.v("ltm","getItem("+position+")");
        return position;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.v("ltm","getCount()");
        return tab_images_pour_la_liste.length;
    }

    Context _context;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        //if( convertView == null ) {
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        textView.setText(values[position]);

        imageView.setImageResource(tab_images_pour_la_liste[position]);
        /*}else {
            rowView = (View)convertView;
        }*/

        Log.v("ltm", "Position = " + position);

        return rowView;
    }

    public MonAdaptateurDeListe(Context context) {
        super();
        _context = context;
    }
}
