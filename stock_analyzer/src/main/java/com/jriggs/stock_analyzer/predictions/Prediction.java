package com.jriggs.stock_analyzer.predictions;

import com.jriggs.stockanalyzer.jsonentity.TimeSeries;


/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public interface Prediction {

    public String getPredictionName();
    public int getPercentUp(TimeSeries ts);
    
}
