package com.ltrix.jk.tv_app.webservice;

/**
 * Created by bindu on 20/09/17.
 */

public class RestServiceBuilder {

    private static RestService service;

    public static RestService getApiService() {
        service = ServiceGenerator.createService(RestService.class);
        return service;
    }


}
