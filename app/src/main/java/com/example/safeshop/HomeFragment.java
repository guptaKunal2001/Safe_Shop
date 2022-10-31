package com.example.safeshop;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home2, container, false);

        categoryRecyclerView=view.findViewById(R.id.category_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Shirts"));
        categoryModelList.add(new CategoryModel("link","T-Shirts"));
        categoryModelList.add(new CategoryModel("link","Jeans"));
        categoryModelList.add(new CategoryModel("link","Dresses"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Shorts"));
        categoryModelList.add(new CategoryModel("link","Watches"));
        categoryModelList.add(new CategoryModel("link","Shoes"));
        categoryModelList.add(new CategoryModel("link","Kurtas"));
        categoryModelList.add(new CategoryModel("link","Ethnic Wear"));
        categoryModelList.add(new CategoryModel("link","Footwear"));


        categoryAdapter=new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

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
        testing=view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.ad_banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner1,"#ff0000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ////////////////

        return view;
    }
}