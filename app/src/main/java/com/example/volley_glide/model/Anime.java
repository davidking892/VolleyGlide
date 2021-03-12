package com.example.volley_glide.model;

public class Anime {

    private String name;
    private String description;
    private String rating;
    private String nb_episode;
    private String image_url;
    private String category;
    private String studio;

    public Anime(){}

    public Anime(String name, String description, String rating, String nb_episode, String image_url, String category, String studio) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.image_url = image_url;
        this.category = category;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(String nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
