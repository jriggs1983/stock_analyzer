package com.jriggs.stock_analyzer.datasources;

import com.google.gson.Gson;
import com.jriggs.stock_analyzer.datareaders.DataReader;
import com.jriggs.stock_analyzer.datareaders.RestDataReader;
import com.jriggs.stock_analyzer.jsonentity.IndicatorSeries;
import com.jriggs.stock_analyzer.jsonentity.TimeSeries;
import com.jriggs.stock_analyzer.params.Params;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/**
 *
 * @author Jacob Riggs
 */
public class AlphaVantageDataSource implements DataSource {

    private final List<DataReader> dataReaders;
    public AlphaVantageDataSource() {
        dataReaders = new ArrayList();
        dataReaders.add(new RestDataReader());
    }

    public static TimeSeries fromJson(String json) throws ParseException {
        JSONObject jsonObject = new JSONObject(json);
        String name = parseName(jsonObject);
        JSONObject tsElement = jsonObject.getJSONObject(name);
        Set<String> keys = tsElement.keySet();
        TimeSeries ts = new TimeSeries();
        ts.setTimeUnit(name);
        ts.setUnits(new ArrayList());
        Gson gson = new Gson();

        for (String key : keys) {
            TimeSeries.Unit u = gson.fromJson(tsElement.getJSONObject(key).toString(), TimeSeries.Unit.class);
            u.setDate(parseDateFromName(key));
            ts.getUnits().add(u);
        }
        ts.sort();
        return ts;
    }

    private static String parseName(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            if (key.toLowerCase().contains("time series")) {
                return key;
            }
        }

        return null;
    }

    private static Date parseDateFromName(String name) throws ParseException {
        String dateFormat = "yyyy-MM-dd";
        if (name.length() == 19) {
            dateFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.parse(name);
    }

    public static void main(String[] args) throws ParseException {

//        String json = "{\n"
//                + "    \"Meta Data\": {\n"
//                + "        \"1. Information\": \"Daily Prices (open, high, low, close) and Volumes\",\n"
//                + "        \"2. Symbol\": \"v\",\n"
//                + "        \"3. Last Refreshed\": \"2019-06-27 14:54:50\",\n"
//                + "        \"4. Output Size\": \"Compact\",\n"
//                + "        \"5. Time Zone\": \"US/Eastern\"\n"
//                + "    },\n"
//                + "    \"Time Series (Daily)\": {\n"
//                + "        \"2019-06-27\": {\n"
//                + "            \"1. open\": \"172.1200\",\n"
//                + "            \"2. high\": \"172.4000\",\n"
//                + "            \"3. low\": \"170.3300\",\n"
//                + "            \"4. close\": \"171.1500\",\n"
//                + "            \"5. volume\": \"2632971\"\n"
//                + "        },\n"
//                + "                         \"2019-06-28\": {\n"
//                + "            \"1. open\": \"172.3200\",\n"
//                + "            \"2. high\": \"172.430\",\n"
//                + "            \"3. low\": \"170.3300\",\n"
//                + "            \"4. close\": \"173.1500\",\n"
//                + "            \"5. volume\": \"2632971\"\n"
//                + "        }\n"
//                + "         }\n"
//                + "}\n"
//                + "         ";
//
//        TimeSeries ts = TimeSeries.fromJson(json);
//        System.out.println(ts.timeUnit);
//        System.out.println(ts.getUnits().size() + " units found");
//        for (TimeSeries.Unit u : ts.getUnits()) {
//            System.out.println(u.getDate());
//            System.out.println("close price: " + u.getClose());
//        }
    }

    @Override
    public TimeSeries getTimeSeries(Params params) {
        
        dataReaders.get(0).
        
    }

    @Override
    public IndicatorSeries getIndicatorSeries(Params params) {
        return null;
    }

}
