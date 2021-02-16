package com.jriggs.stock_analyzer.predictions;

import com.jriggs.stockanalyzer.jsonentity.TimeSeries;
import com.jriggs.stockanalyzer.jsonentity.TimeSeries.Unit;


/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 *
 */
public class RedToGreen implements Prediction {

    @Override
    public int getPercentUp(TimeSeries ts) {
        return analyzeTimeSeries(ts);
    }

    private int analyzeTimeSeries(TimeSeries ts) {

        int greens = 0;
        int total = ts.getUnits().size();
        Boolean yesterdayRed = null;
        for (Unit u : ts.getUnits()) {
            if (yesterdayRed == null) {
                yesterdayRed = u.getClose() < u.getOpen();
                continue;
            }
            boolean todayGreen = u.getOpen() > u.getClose();
            if (todayGreen) {
                greens++;
            }
            yesterdayRed = u.getClose() < u.getOpen();
        }

        double percent = ((double) greens / total) * 100;
        return (int) percent;
    }

    @Override
    public String getPredictionName() {
        return "Red To Green";
    }

}
