package com.sample.viewpagercarousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * MainActivity -> ViewPagerCarouselView -> ViewPagerCarouselAdapter -> ViewPagerCarouselFragment
 */
public class MainActivity extends AppCompatActivity {

    ViewPagerCarouselView viewPagerCarouselView;

    ArrayList<ImageModel> imageModelsList;
    String postData;
    ArrayList<ImageModel> imageModelsListJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long carouselSlideInterval = 3000; // 3 SECONDS
        int[] imageResourceIds = {R.drawable.car6, R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5, R.drawable.car6, R.drawable.car1}; // car6 on 0, and car1 on last for circular scroll purpose

        imageModelsList = new ArrayList<>();
        ImageModel imageModel = new ImageModel(R.drawable.car1);
        imageModelsList.add(imageModel);
        imageModel = new ImageModel(R.drawable.car2);
        imageModelsList.add(imageModel);
        imageModel = new ImageModel(R.drawable.car3);
        imageModelsList.add(imageModel);
        imageModel = new ImageModel(R.drawable.car4);
        imageModelsList.add(imageModel);
        imageModel = new ImageModel(R.drawable.car5);
        imageModelsList.add(imageModel);
        imageModel = new ImageModel(R.drawable.car6);
        imageModelsList.add(imageModel);

        postData=new Gson().toJson(imageModelsList).toString();
        Log.e("postData",postData);
        imageModelsListJson=new ArrayList<>();

        try {
            //JSON is the JSON code above

            JSONArray images = new JSONArray(postData);
            Log.e("images",images.length()+"");
            for(int i=0;i<images.length();i++){
                JSONObject jsonObj = images.getJSONObject(i);
                int imageId = jsonObj.getInt("imageId");
                ImageModel  imageModel1=new ImageModel(imageId);
                imageModelsListJson.add(imageModel1);
            }

            Log.e("imagesSize",imageModelsListJson.size()+"");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        viewPagerCarouselView = (ViewPagerCarouselView) findViewById(R.id.carousel_view);
//        viewPagerCarouselView.setData(getSupportFragmentManager(), imageResourceIds, carouselSlideInterval);
        viewPagerCarouselView.setData(getSupportFragmentManager(), imageModelsListJson, carouselSlideInterval);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPagerCarouselView.onDestroy();
    }
}
