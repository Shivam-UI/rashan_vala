package com.lgt.Model;

public class CategoryModel {

    String CardBackground,ImageURL;

    public CategoryModel(String cardBackground, String imageURL) {
        CardBackground = cardBackground;
        ImageURL = imageURL;
    }

    public String getCardBackground() {
        return CardBackground;
    }

    public void setCardBackground(String cardBackground) {
        CardBackground = cardBackground;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
