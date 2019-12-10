package com.ctucs310.macandcheezary;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserCustomAdapter extends ArrayAdapter<User> {
    Context context;
    int layoutResourceId;
    ArrayList<User> data = new ArrayList<User>();

    public UserCustomAdapter(Context context, int layoutResourceId,
                             ArrayList<User> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        UserHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new UserHolder();
            holder.textName = (TextView) row.findViewById(R.id.textItemName);
            holder.textPrice = (TextView) row.findViewById(R.id.textViewItemPrice);
            holder.textComments = (TextView) row.findViewById(R.id.textViewComments);
            holder.btnEdit = (Button) row.findViewById(R.id.buttonEditOrder);
            holder.btnDelete = (Button) row.findViewById(R.id.buttonDeleteItem);
            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        User user = data.get(position);
        holder.textName.setText(user.getName());
        holder.textPrice.setText(user.getPrice());
        holder.textComments.setText(user.getComments());
        holder.btnEdit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Edit Order Btn Clicked", "**********");
                Toast.makeText(context, "Edit Order Btn Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });
        holder.btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Remove Item Btn Clicked", "**********");
                Toast.makeText(context, "Remove Item Btn Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });
        return row;

    }

    static class UserHolder {
        TextView textName;
        TextView textPrice;
        TextView textComments;
        Button btnEdit;
        Button btnDelete;
    }
}

