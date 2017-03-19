package com.example.meruguabhishek.zoompinch;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by meruguabhishek on 2017-03-18.
 */


public class ListAdapter  extends ArrayAdapter<ListItem> {

    List<ListItem> listItems;
    Context mContext;
    float scale=1f;
    private ArrayList<Integer> selectedPositions=new ArrayList<>();

    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
        setListItems(objects);
        setmContext(context);
    }

    public void setScale(float scale) {
        this.scale = scale;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }
    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }
    //    public ListAdapter(@NonNull Context context) {
//        super(context);
//        setmContext(context);
//    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

//    public void setEv(MotionEvent ev) {
//        this.ev = ev;
//    }

    @Override
public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater li =  ((Activity) mContext).getLayoutInflater();
            convertView = li.inflate(R.layout.list_item, null);
        holder = new ViewHolder();
            holder.cardView = (CardView) convertView.findViewById(R.id.card_view);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.company= (TextView) convertView.findViewById(R.id.company);
            holder.imageView= (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }
        else {
        holder = (ViewHolder) convertView.getTag();
        }

        ListItem item = getItem(position);
        holder.name.setText(item.getName());
        holder.imageView.setImageResource(item.getDrawable());
        holder.company.setText(item.getCompany());
        convertView.setScaleX(scale);
        convertView.setScaleY(scale);
        if (scale<=1.03f){
            convertView.setElevation(4);
        }else {
            if (selectedPositions.contains(position)){
                convertView.setElevation(32);
            }
        }
//        holder.cardView.setmScaleFactor(scale);
//
//        holder.nameTextView.setText(person.getName());
//        holder.surnameTextView.setText(person.getSurname());
        //holder.personImageView.setImageBitmap(person.getImage());
        return convertView;
        }

    public ArrayList<Integer> getSelectedPositions() {
        return selectedPositions;
    }

    public void setSelectedPositions(ArrayList<Integer> selectedPositions) {
        this.selectedPositions = selectedPositions;
    }

    public class ViewHolder {
        private ImageView imageView;
        private CardView cardView;
        private TextView name;
        private TextView company;
    }
        }
