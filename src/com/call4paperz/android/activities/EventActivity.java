package com.call4paperz.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.call4paperz.android.Constants;
import com.call4paperz.android.R;
import com.call4paperz.android.model.Event;
import com.squareup.picasso.Picasso;

public class EventActivity extends ActionBarActivity {

    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        event = (Event) getIntent().getExtras().getSerializable(Constants.EVENT);

        ImageView logo = (ImageView) findViewById(R.id.logo);
        String imageURL = event.getPicture().getCropped().getUrl();
        Picasso.with(this).load(imageURL).placeholder(R.drawable.no_image).into(logo);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(event.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(event.getDescription());

        TextView date = (TextView) findViewById(R.id.date);
        date.setText(event.getStringDate());

        TextView url = (TextView) findViewById(R.id.url);
        url.setText(event.getUrl());

        TextView twitter = (TextView) findViewById(R.id.twitter);
        twitter.setText(event.getTwitter());

        TextView organizer = (TextView) findViewById(R.id.organizer);
        organizer.setText(event.getOrganizer().getName());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(EventActivity.this, ProposalsActivity.class);
        intent.putExtra("event", event);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}
