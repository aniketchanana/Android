package com.aniket.recyclerview;

public class item {
    String text1;
    String text2;
    int image;
    item(int image, String text1, String text2)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.image = image;
    }
    String getText1(){
        return text1;
    }
    String getText2(){
        return text2;
    }
    int getImage(){
        return image;
    }
}
