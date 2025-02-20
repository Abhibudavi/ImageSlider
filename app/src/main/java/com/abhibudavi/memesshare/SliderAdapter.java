package com.abhibudavi.memesshare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private List<SliderItem> sliderItemList;
    private ViewPager2 viewPager2;

     SliderAdapter(List<SliderItem> sliderItemList, ViewPager2 viewPager2) {
        this.sliderItemList = sliderItemList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_item_container,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
            holder.setImageView(sliderItemList.get(position));
            if (position == sliderItemList.size() - 2 ){
                viewPager2.post(runnable);
            }
    }

    @Override
    public int getItemCount() {
        return sliderItemList.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;


        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        void setImageView(SliderItem sliderItem){

            //if you want to display image from the internet,
            // you can put code here using glide or picasso.

            imageView.setImageResource(sliderItem.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                sliderItemList.addAll(sliderItemList);
                notifyDataSetChanged();
        }
    };
}
