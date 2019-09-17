package com.yusril.submission3async.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yusril.submission3async.Model.MovieModel;
import com.yusril.submission3async.Model.TvModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "390f8331c63bb6f8ab6f690e817b7c97";
    private MutableLiveData<ArrayList<MovieModel>> listMovies = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TvModel>> listTv = new MutableLiveData<>();  public void setMovie(final String type) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<MovieModel> listItems = new ArrayList<>();
        final ArrayList<TvModel> listItemsTv = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/"+ type +"?api_key=" + API_KEY +"&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    String result = new String(responseBody);
                    Log.d("API Result", result);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movie = list.getJSONObject(i);
                        MovieModel movieItems = new MovieModel(movie);
                        listItems.add(movieItems);
                    }
                    listMovies.postValue(listItems);

                }
                catch (Exception e) {

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public LiveData<ArrayList<MovieModel>> getMovie() {
        return listMovies;
    }

    public void setTv(final String type) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvModel> listItemsTv = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/"+ type +"?api_key=" + API_KEY +"&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    Log.d("API Result", result);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject tv = list.getJSONObject(i);
                        TvModel tvItems = new TvModel(tv);
                        listItemsTv.add(tvItems);
                    }
                    listTv.postValue(listItemsTv);
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public LiveData<ArrayList<TvModel>> getTv(){
        return listTv;
    }
}

