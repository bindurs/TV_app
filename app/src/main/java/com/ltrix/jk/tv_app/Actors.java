package com.ltrix.jk.tv_app;

/**
 * Created by bindu on 19/09/17.
 */

public class Actors {

    private String name,characters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public Actors(String name, String characters) {

        this.name = name;
        this.characters = characters;
    }
}
