package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    // using custom layout -> MyCustomAdapter
    // using custom layout -> ArrayAdapter<Planet>
    private ArrayList<Planet> planetsArrayList;
    Context context;


    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    private static class MyViewHolder{
        TextView planet_name;
        TextView moonCount;
        ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1 get the planet object for the curretn position
        Planet planet = getItem(position);
        //2 inflate layout
        MyViewHolder holder;
        final View result;

        if (convertView == null){
            holder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            // finding views
            holder.planet_name = (TextView) convertView.findViewById(R.id.planet_name);
            holder.moonCount = (TextView) convertView.findViewById(R.id.moonCount);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(holder);
        }else{
            // the view is recycled
            holder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        //getting the data from the model class
        holder.planet_name.setText(planet.getPlanetName());
        holder.moonCount.setText(planet.getMoonCount());
        holder.imageView.setImageResource(planet.getPlanetImage());

        return result;
    }
}
