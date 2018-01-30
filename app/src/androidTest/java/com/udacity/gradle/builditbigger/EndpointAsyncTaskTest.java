package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by diego on 30/01/18.
 */

public class EndpointAsyncTaskTest extends AndroidTestCase {

    public void testNotEmptyString() throws ExecutionException, InterruptedException {
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(getContext());
        endpointAsyncTask.execute();

        String result = endpointAsyncTask.get();
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
