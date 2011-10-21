package com.call4paperz.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.call4paperz.R;
import com.call4paperz.model.Event;
import com.call4paperz.util.BitmapGenerator;

import java.util.List;

public class EventsAdapter extends ArrayAdapter<Event> {

    public EventsAdapter(Context context, List<Event> events) {
        super(context, R.layout.events_line, R.event.name, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Event event = getItem(position);

        View view = super.getView(position, convertView, parent);

        final ImageView logo = (ImageView) view.findViewById(R.event.logo);

        AsyncTask<String, ProgressDialog, Bitmap> imageLoad = new BitmapGenerator(logo);
        imageLoad.execute(event.getImageUrl());

        return view;

    }

}