package com.ltrix.jk.tv_app;

/**
 * Created by bindu on 18/09/17.
 */

public class Episode {

    private int episodeID,episodeNumber,airedSeason,runtime;
    private String episodeURL,episodeName,episodeImage,summary,url;

    public Episode(int episodeID, int episodeNumber, int airedSeason, int runtime, String episodeURL, String episodeName, String episodeImage, String summary, String url) {
        this.episodeID = episodeID;
        this.episodeNumber = episodeNumber;
        this.airedSeason = airedSeason;
        this.runtime = runtime;
        this.episodeURL = episodeURL;
        this.episodeName = episodeName;
        this.episodeImage = episodeImage;
        this.summary = summary;
        this.url = url;
    }

    public int getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(int episodeID) {
        this.episodeID = episodeID;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getAiredSeason() {
        return airedSeason;
    }

    public void setAiredSeason(int airedSeason) {
        this.airedSeason = airedSeason;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getEpisodeURL() {
        return episodeURL;
    }

    public void setEpisodeURL(String episodeURL) {
        this.episodeURL = episodeURL;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getEpisodeImage() {
        return episodeImage;
    }

    public void setEpisodeImage(String episodeImage) {
        this.episodeImage = episodeImage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
