package com.example.safeshop;

import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNERSLIDER;
            case 1:
                return HomePageModel.STRIPAD_BANNER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomePageModel.BANNERSLIDER:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_add_layout, parent, false);
                return new BannerSliderViewHolder(bannerSliderView);
            case HomePageModel.STRIPAD_BANNER:
                View stripAdView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_add_layout, parent, false);
                return new StripAdBannerViewHolder(stripAdView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_layout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout, parent, false);
                return new GridProductViewHolder(gridProductView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNERSLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) holder).setBannerSliderViewPager(sliderModelList);
                break;
            case HomePageModel.STRIPAD_BANNER:
                int resource=homePageModelList.get(position).getResource();
                String color=homePageModelList.get(position).getBackgroundColor();
                ((StripAdBannerViewHolder)holder).setStripAd(resource,color);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle=homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModel> horizontalProductScrollModelList=homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((HorizontalProductViewHolder)holder).setHorizontalProductLayout(horizontalProductScrollModelList,horizontalLayoutTitle);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridLayoutTitle=homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModel> gridProductScrollModelList=homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((GridProductViewHolder)holder).setGridProductLayout(gridProductScrollModelList,gridLayoutTitle);
                break;
            default:
                return;
        }
    }
    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }
    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderViewPager;
        private int currentPage = 2;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 3000;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_view_pager);

        }

        private void setBannerSliderViewPager(List<SliderModel> sliderModelList) {
            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            bannerSliderViewPager.setAdapter(sliderAdapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);

            bannerSliderViewPager.setCurrentItem(currentPage);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) ;
                    {
                        pageLooper(sliderModelList);
                    }
                }
            };
            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);
            startBannerSlideShow(sliderModelList);
            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    pageLooper(sliderModelList);
                    stopBannerSlideShow();
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        startBannerSlideShow(sliderModelList);
                    }
                    return false;
                }
            });
        }

        private void pageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage, false);
            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannerSliderViewPager.setCurrentItem(currentPage, false);
            }
        }

        private void startBannerSlideShow(List<SliderModel> sliderModelList) {
            Handler handler = new Handler();
            Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannerSliderViewPager.setCurrentItem(currentPage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopBannerSlideShow() {
            timer.cancel();
        }
    }
    public class StripAdBannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            stripAdImage = itemView.findViewById(R.id.strip_add_image);
            stripAdContainer = itemView.findViewById(R.id.strip_add_container);
        }

        private void setStripAd(int resource, String color) {
            stripAdImage.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }
    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder{
        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllBtn;
        private RecyclerView horizontalRecyclerView;
        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle=itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalLayoutViewAllBtn=itemView.findViewById(R.id.horizontal_scroll_view_all_button);
            horizontalRecyclerView=itemView.findViewById(R.id.horizontal_scroll_layout_recyclerview);
        }
        private void setHorizontalProductLayout(List<HorizontalProductScrollModel> horizontalProductScrollModelList,String title){
            horizontalLayoutTitle.setText(title);
            if(horizontalProductScrollModelList.size()>8){
                horizontalLayoutViewAllBtn.setVisibility(View.VISIBLE);
            }else{
                horizontalLayoutViewAllBtn.setVisibility(View.INVISIBLE);
            }
            HorizontalProductScrollAdapter horizontalProductScrollAdapter=new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);
            horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();
        }
    }
    public class GridProductViewHolder extends RecyclerView.ViewHolder{
        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBtn;
        private GridView gridView;
        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridLayoutTitle=itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewAllBtn=itemView.findViewById(R.id.grid_product_layout_view_btn);
            gridView=itemView.findViewById(R.id.grid_product_layout_gridview);
        }
        private void setGridProductLayout(List<HorizontalProductScrollModel> horizontalProductScrollModelList,String title){
            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));
        }
    }

}
