package com.jriggs.stock_analyzer.predictions;

import com.jriggs.stock_analyzer.jsonentity.TimeSeries;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class SecondCandleUpDollar implements Prediction {

    @Override
    public String getPredictionName() {
        return "SecondCandleUpDollar";
    }

    @Override
    public int getPercentUp(TimeSeries ts) {
        Boolean yesterdayGreen = null;

        Date startDate = null;
        double firstCandleClose = 0;
        
        int workCount = 0;
        boolean worked = false;
        int total = 0;
        for (TimeSeries.Unit u : ts.getUnits()) {
            if (startDate == null) {
                startDate = u.getDate();
                firstCandleClose = u.getClose();
            } else if (!isSameDay(startDate, u.getDate())) {
                startDate = u.getDate();
                firstCandleClose = u.getClose();
                total++;
                worked = false;
            }
            if (!worked && (u.getClose() > (firstCandleClose + 8))) {
                workCount++;
                worked = true;
            }
        }

        double percent = ((double) workCount / total) * 100;
        return (int) percent;
    }

    private boolean isSameDay(Date d1, Date d2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

}
