package com.ltrix.jk.tv_app.webservice;

import com.ltrix.jk.tv_app.model.Actor;
import com.ltrix.jk.tv_app.model.Episode;
import com.ltrix.jk.tv_app.model.Season;
import com.ltrix.jk.tv_app.model.Show;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bindu on 20/09/17.
 */

public interface RestService {

    @GET("/show")
    Call <List<Show>>getShows(@Query("page") int page);

    @GET("/shows/{id}/seasons")
    Call <List<Season>>getSeasons(@Path("id") int id);

    @GET("/shows/{id}/cast")
    Call <List<Actor>>getActors(@Path("id") int id);

    @GET("/shows/{id}/episodes")
    Call <List<Episode>>getEpisodes(@Path("id") int id);

}
