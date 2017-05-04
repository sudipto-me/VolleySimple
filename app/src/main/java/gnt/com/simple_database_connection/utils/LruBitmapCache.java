package gnt.com.simple_database_connection.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by PC-05 on 5/4/2017.
 */

public class LruBitmapCache extends LruCache<String,Bitmap> implements ImageLoader.ImageCache {




    public static int getDefaultLruCacheSize(){
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = (maxMemory)/8;
        return cacheSize;
    }

    public LruBitmapCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    public LruBitmapCache(){
        this(getDefaultLruCacheSize());
    }

    public int sizeOf(String key,Bitmap value){

        return value.getRowBytes()*value.getHeight();

    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {

        put(url,bitmap);

    }
}
