package com.jade.library;

/**
 * Created by jade on 16-8-2.
 */
public class LibManager {
    private static LibManager ourInstance = new LibManager();

    public static LibManager getInstance() {
        return ourInstance;
    }

    private LibManager() {
    }

    public void init(Configuration cfg){

    }
}
