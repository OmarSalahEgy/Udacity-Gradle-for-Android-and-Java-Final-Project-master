

package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import theo.tziomakas.jokesandroidlib.JokesActivity;


/**
 * Created by Theodosios Tziomakas as part of Udacity Nanodegree's project 'Build it bigger' on 15-April-17.
 */

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    public static MyApi myApiService = null;
    private Context context;
    String text;


    @Override
    protected String doInBackground(Context...params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getRandomJokeService().execute().getData();
        } catch (IOException e) {
            Log.i("Error Retrieving Jokes", e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        final Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra("gce_result",result);
        context.startActivity(intent);
    }
}

