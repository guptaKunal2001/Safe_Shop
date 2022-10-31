package com.example.safeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView=findViewById(R.id.category_recycler_view);

        //////////banner slider
        List<SliderModel> sliderModelList =new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner1,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner2,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner3,"#FFCE0000"));

        sliderModelList.add(new SliderModel(R.drawable.banner4,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner5,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.safe_shop,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner3,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner1,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#FFCE0000"));

        sliderModelList.add(new SliderModel(R.drawable.banner2,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner3,"#FFCE0000"));
        sliderModelList.add(new SliderModel(R.drawable.banner4,"#FFCE0000"));
        /////////banner slider

        ////////////horizontal product layout
        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt1,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt2,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt1,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt2,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt1,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt2,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt1,"Men's Tshirt","ajio.com","Rs.550/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.men_tshirt2,"Men's Tshirt","ajio.com","Rs.550/-"));
        ////////////horizontal product layout

        ////////////////
        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.ad_banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner1,"#ff0000"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.main_search_icon){
            ///search
            return true;
        }else if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}