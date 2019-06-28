package com.jriggs.stock_analyzer.params;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Jacob Riggs (jacobriggs83@gmail.com)
 */
public class Params implements TransactionParams {

    private List<NameValuePair> paramList;

    @Override
    public List<NameValuePair> getNameValuePair() {
        return paramList;
    }

    public void addParam(String name, String value) {
        if (paramList == null) {
            paramList = new ArrayList();
        }
        paramList.add(new BasicNameValuePair(name, value));
    }

    public enum Function {

        TIME_SERIES_INTRADAY, TIME_SERIES_DAILY, TIME_SERIES_WEEKLY, TIME_SERIES_MONTHLY,
    }

    public enum Interval {
        ONE_MIN("1min"), FIVE_MIN("5min"), FIFTEEN_MIN("15min"), THIRTY_MIN("30min"), SIXTY_MIN("60min"), SECTOR("sector");

        String val;

        Interval(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

    }

    public enum OutputSize {
        COMPACT, FULL
    }

    public enum TechnicalIndicators {
        SMA, EMA, WMA, DEMA, TEMA, TRIMA, KAMA, MAMA, VWAP, T3, MACD, MACDEXT, STOCH, STOCHF, RSI, STOCHRSI, WILLR, ADX, ADXR, APO, PPO, MOM,
        BOP, CCI, CMO, ROC, ROCR, AROON, AROONOSC, MFI, TRIX, ULTOSC, DX, MINUS_DI, PLUS_DI, MINUS_DM, PLUS_DM, BBANDS, MIDPOINT, MIDPRICE, SAR,
        TRANGE, ATR, NATR, AD, ADOSC, OBV, HT_SINE, HT_TRENDLINE, HT_DCPERIOD, HT_DCPHASE, HT_PHASOR
    }

}
