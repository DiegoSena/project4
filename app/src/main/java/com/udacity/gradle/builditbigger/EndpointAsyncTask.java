package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.android.jokeandroidlibrary.DisplayJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import backend.builditbigger.gradle.udacity.com.jokeApi.JokeApi;
import backend.builditbigger.gradle.udacity.com.jokeApi.model.JokeTellerBean;

/**
 * Created by diego on 23/01/18.
 */

public class EndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private JokeApi myApi;
    private Context context;

    public EndpointAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>[] params) {
        if(myApi == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(context.getString(R.string.root_api_url))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApi = builder.build();
        }

        try {
            return myApi.putJoke(new JokeTellerBean()).execute().getJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.INTENT_EXTRA, joke);
        context.startActivity(intent);
    }
}
