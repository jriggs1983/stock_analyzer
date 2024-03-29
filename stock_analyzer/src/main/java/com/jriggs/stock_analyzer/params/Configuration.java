package com.jriggs.stock_analyzer.params;

/**
 * Configurable parameters.
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class Configuration {

    public static final String API_KEY = "5PPGQEQ7JEA2BZX9";
    public static final String URI = "https://www.alphavantage.co/query";

    public static String getUri() {
        return URI;
    }

    public static String getApiKey() {
        return API_KEY;
    }

}
