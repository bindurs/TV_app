package com.ltrix.jk.tv_app;

import android.util.Log;

import com.ltrix.jk.tv_app.model.Season;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bindu on 18/09/17.
 */

public class ShowsInfo {

    private List<Season> airedSeasons = new ArrayList<>();
    private List<Episode> airedEpisodes = new ArrayList<>();

    public ShowsInfo () {
        
    }

    public ShowsInfo(List<Season> airedSeasons, List<Episode> airedEpisodes) {
        this.airedSeasons = airedSeasons;
        this.airedEpisodes = airedEpisodes;
    }

    public List<Season> getAiredSeasons() {
        return airedSeasons;
    }

    public void setAiredSeasons(List<Season> airedSeasons) {
        this.airedSeasons = airedSeasons;
    }

    public List<Episode> getAiredEpisodes() {

        Log.v("======================",airedEpisodes.toString());
        return airedEpisodes;
    }

    public void setAiredEpisodes(List<Episode> airedEpisodes) {
        this.airedEpisodes = airedEpisodes;
    }
}
