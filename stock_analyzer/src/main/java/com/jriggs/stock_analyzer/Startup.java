/*
 * Jacob Riggs (jacobriggs83@gmail.com)
 */
package com.jriggs.stock_analyzer;


import com.jriggs.stock_analyzer.jsonentity.TimeSeries;
import com.jriggs.stock_analyzer.predictions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CyberPower
 */
public class Startup {

//    https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=v&apikey=KYSTXRCY4FVM6VKW&outputsize=full
    public static void main(String[] args) {
        try {
            Http http = new Http();
            String s = http.get(null, null, "https://www.alphavantage.co/query");
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
}
