package com.ltrix.jk.tv_app;

/**
 * Created by bindu on 18/09/17.
 */

public class Season {


    private int seasonID,number,episodeOrder;
    private String url,name,premiereDate,endDate,image,summary,links;

    public Season () {

    }

    public Season(int seasonID, int number, int episodeOrder, String url, String name, String premiereDate, String endDate, String image, String summary, String links) {
        this.seasonID = seasonID;
        this.number = number;
        this.episodeOrder = episodeOrder;
        this.url = url;
        this.name = name;
        this.premiereDate = premiereDate;
        this.endDate = endDate;
        this.image = image;
        this.summary = summary;
        this.links = links;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEpisodeOrder() {
        return episodeOrder;
    }

    public void setEpisodeOrder(int episodeOrder) {
        this.episodeOrder = episodeOrder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

}
