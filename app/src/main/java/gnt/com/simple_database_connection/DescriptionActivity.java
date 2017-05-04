package gnt.com.simple_database_connection;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONObject;

public class DescriptionActivity extends AppCompatActivity {

    public TextView flowerDescription;
    public ImageView flowerImage;
    String server_URL = "http://services.hanselandpetal.com/photos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        flowerDescription = (TextView) findViewById(R.id.tv_description);
        flowerImage = (ImageView) findViewById(R.id.iv_flower_image);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        ImageRequest imageRequest = new ImageRequest(server_URL, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                flowerImage.setImageBitmap(response);

            }
        },0,0,ImageView.ScaleType.CENTER_CROP,null,
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("Error",toString());
                    }
                });


        MySingleton.getmInstance(DescriptionActivity.this).addToRequestQue(imageRequest);





    }


}
