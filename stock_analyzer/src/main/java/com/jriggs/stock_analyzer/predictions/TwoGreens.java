package com.jriggs.stock_analyzer.predictions;

import com.jriggs.stock_analyzer.jsonentity.TimeSeries;


/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class TwoGreens implements Prediction {

    @Override
    public String getPredictionName() {
        return "Two Greens";
    }

    @Override
    public int getPercentUp(TimeSeries ts) {
        return analyze(ts);
    }

    private int analyze(TimeSeries ts) {
        int greens = 0;
        int total = 0;
        Boolean yesterdayGreen = null;
        for (TimeSeries.Unit u : ts.getUnits()) {
            if (yesterdayGreen == null) {
                yesterdayGreen = u.getClose() > u.getOpen();
                continue;
            }
            boolean todayGreen = u.getOpen() > u.getClose();
            if (todayGreen && yesterdayGreen) {
                greens++;
            }
            if (todayGreen) {
                total++;
            }
            yesterdayGreen = u.getClose() > u.getOpen();
        }

        double percent = ((double) greens / total) * 100;
        return (int) percent;
    }

}
