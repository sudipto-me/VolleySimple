package gnt.com.simple_database_connection;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<Flower> flowerList;

    public String json;
    public RecyclerView mRecyclerView;
    public FlowerAdapter mFlowerAdapter;
    public LinearLayoutManager mLinearLayoutManager;
    public ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar = (ProgressBar) findViewById(R.id.pb_round_progress);
        progressbar.setVisibility(View.VISIBLE);



        mRecyclerView = (RecyclerView) findViewById(R.id.rv_simple_volley);
        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(MainActivity.this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setVisibility(View.GONE);



        sendRequest();
        mRecyclerView.setVisibility(View.VISIBLE);


        //mFlowerAdapter.notifyDataSetChanged();


    }


    public void sendRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://services.hanselandpetal.com/feeds/flowers.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder builder = new GsonBuilder();
                        Gson mGson = builder.create();
                        List<Flower> flowers = new ArrayList<Flower>();
                        flowers = Arrays.asList(mGson.fromJson(response, Flower[].class));
                        mFlowerAdapter = new FlowerAdapter(MainActivity.this, flowers);
                        mRecyclerView.setAdapter(mFlowerAdapter);

                        if(progressbar.getVisibility() == View.VISIBLE) {
                            progressbar.setVisibility(View.INVISIBLE);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Service not availabe", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);
    }


}
