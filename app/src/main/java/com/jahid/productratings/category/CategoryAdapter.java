package com.jahid.productratings.category;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jahid.productratings.R;

public class CategoryAdapter extends ArrayAdapter<String> {

    private Activity context;
    private final String[] category;

    public CategoryAdapter(Activity context, String[] category) {
        super(context, R.layout.category_layout, category);
        this.context = context;
        this.category = category;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.category_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.text);


        //Category category = categoryList.get(position);

        textViewName.setText(category[position]);
        return listViewItem;
    }
}
