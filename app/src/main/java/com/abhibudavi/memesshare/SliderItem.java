package com.abhibudavi.memesshare;

public class SliderItem {

    //Here you can use string variable to store url
    // if you want to load image from the internet url
    private int image;


    public SliderItem(){

    };

    public SliderItem(int image){
        this.image = image;
    }



    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image=image;
    }
}
