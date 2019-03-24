package com.jahid.productratings.product;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jahid.productratings.R;
import com.jahid.productratings.model.Function;

public class ProductAdapter {

    /* extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
    private Context context;
   // private List<LauncherActivity.ListItem> listItems;
    private ProductAdapter adapter;

    public ProductAdapter(Context context, List<> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {

        LauncherActivity.ListItem item = listItems.get(position);

        holder.title.setText(item.getName());
        holder.description.setText(item.getAddress());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView description;
        public EditText editText;
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            title = (TextView) itemView.findViewById(R.id.router_name);
            description = (TextView) itemView.findViewById(R.id.router_address_id);
            editText = (EditText) itemView.findViewById(R.id.router_address);
            button = (Button) itemView.findViewById(R.id.go_button);



        }

        @Override
        public void onClick(View v) {

            //Get position of the row clicked or tapped
            int position = getAdapterPosition();

            LauncherActivity.ListItem item = listItems.get(position);
            if (Function.isNetworkAvailable(context)) {


                Intent intent = new Intent(context, DetailsActivity.class);

                intent.putExtra("address", item.getAddress());

                context.startActivity(intent);

            } else {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
            }

        }
    }*/
}
