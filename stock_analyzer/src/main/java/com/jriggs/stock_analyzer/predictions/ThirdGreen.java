package com.jriggs.stock_analyzer.predictions;

import com.jriggs.stock_analyzer.jsonentity.TimeSeries;


/**
 * Odds of 3rd green when on 2 greens.
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class ThirdGreen implements Prediction {

    @Override
    public String getPredictionName() {
        return "Third Green";
    }

    @Override
    public int getPercentUp(TimeSeries ts) {
        return analyze(ts);
    }

    private int analyze(TimeSeries ts) {
        int greens = 0;
        int total = ts.getUnits().size();
        Boolean yesterdayGreen = null;
        
        for (TimeSeries.Unit u : ts.getUnits()) {
            if (yesterdayGreen == null) {
                yesterdayGreen = u.getClose() > u.getOpen();
                continue;
            }
            boolean todayGreen = u.getOpen() > u.getClose();
            if (todayGreen) {
                greens++;
            }
            yesterdayGreen = u.getClose() > u.getOpen();
        }

        double percent = ((double) greens / total) * 100;
        return (int) percent;
    }

}
