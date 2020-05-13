package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import theo.tziomakas.jokeslib.MyCoolJokes;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tellJoke(View view) {

        /*
        MyCoolJokes myCoolJokes = new MyCoolJokes();

        String randromJoke = myCoolJokes.getJoke();

        Intent i = new Intent(this, JokesActivity.class);
        i.putExtra("jokes",randromJoke);
        startActivity(i);

        */
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(this);

    }


}
