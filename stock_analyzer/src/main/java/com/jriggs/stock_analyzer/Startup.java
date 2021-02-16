package com.jriggs.stock_analyzer;

import com.jriggs.stock_analyzer.datareaders.Http;
import com.jriggs.stock_analyzer.params.Params;
import com.jriggs.stock_analyzer.predictions.*;
import com.jriggs.stockanalyzer.jsonentity.TimeSeries;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class Startup {

//    https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=v&apikey=KYSTXRCY4FVM6VKW&outputsize=full
    public static void main(String[] args) {
        try {
            Http http = new Http();
            String s = http.get(null, buildParams(), "https://www.alphavantage.co/query");
            TimeSeries ts = TimeSeries.fromJson(s);

            List<Prediction> predictions = new ArrayList();
            predictions.add(new RedToGreen());
            predictions.add(new TwoGreens());
            predictions.add(new SecondCandleUpDollar());
            for (Prediction p : predictions) {
                System.out.println(
                        p.getPredictionName()
                        + " "
                        + p.getPercentUp(ts));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static Params buildParams() {
        Params p = new Params();
        p.addParam("apikey", "KYSTXRCY4FVM6VKW");
        p.addParam("function", "TIME_SERIES_WEEKLY");
//        p.addParam("interval", "5min");
        p.addParam("symbol", "CRM");
        p.addParam("outputsize", "full");
        return p;
    }

}
