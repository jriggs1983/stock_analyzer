package com.jriggs.stock_analyzer.datareaders;

import com.jriggs.stock_analyzer.params.Configuration;
import com.jriggs.stock_analyzer.params.Params;

/**
 *
 * @author Jacob Riggs
 */
public class RestDataReader implements DataReader {

    private final Http http;

    public RestDataReader() {
        http = new Http();
    }


    @Override
    public String getJson(Params params) {
        http.get(null, params, Configuration.getUri());
        
        return null;
    }
//
//            Params p = new Params();
//        p.addParam("apikey", "KYSTXRCY4FVM6VKW");
//        p.addParam("function", "TIME_SERIES_WEEKLY");
////        p.addParam("interval", "5min");
//        p.addParam("symbol", "CRM");
//        p.addParam("outputsize", "full");
//        return p;
        
    
}
