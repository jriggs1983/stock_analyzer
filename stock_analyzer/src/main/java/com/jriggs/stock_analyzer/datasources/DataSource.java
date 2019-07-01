package com.jriggs.stock_analyzer.datasources;

import com.jriggs.stock_analyzer.jsonentity.IndicatorSeries;
import com.jriggs.stock_analyzer.jsonentity.TimeSeries;
import com.jriggs.stock_analyzer.params.Params;

/**
 *
 * @author jbr5551
 */
public interface DataSource {

    public TimeSeries getTimeSeries(Params params);

    public IndicatorSeries getIndicatorSeries(Params params);

}
