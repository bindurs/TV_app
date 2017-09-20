package com.ltrix.jk.tv_app;

/**
 * Created by bindu on 11/09/17.
 */

public class Shows {

    private int showID;
    private  Double rating;
    private String seriesURL,title,status,runTime,premiered,officialSite,summary, genre, year,imageURL;

    public Shows() {
    }

    public Shows(int showID, String title, String genre, String year, Double rating, String status, String runTime, String premiered, String officialSite, String summary, String seriesURL,String imageURL) {

        this.showID = showID;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.seriesURL = seriesURL;
        this.rating = rating;
        this.status = status;
        this.runTime = runTime;
        this.premiered = premiered;
        this.officialSite = officialSite;
        this.summary = summary;
        this.imageURL = imageURL;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getShowID() { return showID; }

    public void setShowID(int showID) { this.showID = showID; }

    public String getSeriesURL() { return seriesURL; }

    public void setSeriesURL(String seriesURL) { this.seriesURL = seriesURL; }

    public Double getRating() { return rating; }

    public void setRating(Double rating) { this.rating = rating; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getRunTime() { return runTime; }

    public void setRunTime(String runTime) { this.runTime = runTime; }

    public String getPremiered() { return premiered; }

    public void setPremiered(String premiered) { this.premiered = premiered; }

    public String getOfficialSite() { return officialSite; }

    public void setOfficialSite(String officialSite) { this.officialSite = officialSite; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
}
