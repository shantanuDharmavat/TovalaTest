package com.example.testapplication.Models;

import java.io.Serializable;
import java.util.Objects;

public class FoodMenuModel implements Serializable {
    String title;
    String story;
    String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodMenuModel that = (FoodMenuModel) o;
        return title.equals(that.title) &&
                story.equals(that.story) &&
                image.equals(that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, story, image);
    }

    @Override
    public String toString() {
        return "FoodMenuModel{" +
                "title='" + title + '\'' +
                ", story='" + story + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
