package com.jriggs.stock_analyzer.jsonentity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/**
 *
 * @author Jacob Riggs
 */
public class TimeSeries {

    private ArrayList<Unit> units;
    private String timeUnit; //day, month, week, etc.

    public List<Unit> getUnits() {
        return units;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public void sort() {
        Collections.sort(units, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o1.date.compareTo(o2.date);
            }
        });
    }

    public static class Unit {

        private Date date;
        @SerializedName("1. open")
        private double open;

        @SerializedName("2. high")
        private double high;

        @SerializedName("3. low")
        private double low;

        @SerializedName("4. close")
        private double close;

        @SerializedName("5. volume")
        private double volume;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public double getOpen() {
            return open;
        }

        public void setOpen(double open) {
            this.open = open;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public double getClose() {
            return close;
        }

        public void setClose(double close) {
            this.close = close;
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
            this.volume = volume;
        }

    }

    public static TimeSeries fromJson(String json) throws ParseException {
        JSONObject jsonObject = new JSONObject(json);
        String name = parseName(jsonObject);
        JSONObject tsElement = jsonObject.getJSONObject(name);
        Set<String> keys = tsElement.keySet();
        TimeSeries ts = new TimeSeries();
        ts.setTimeUnit(name);
        ts.units = new ArrayList();
        Gson gson = new Gson();

        for (String key : keys) {
            Unit u = gson.fromJson(tsElement.getJSONObject(key).toString(), Unit.class);
            u.setDate(parseDateFromName(key));
            ts.units.add(u);
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

        String json = "{\n"
                + "    \"Meta Data\": {\n"
                + "        \"1. Information\": \"Daily Prices (open, high, low, close) and Volumes\",\n"
                + "        \"2. Symbol\": \"v\",\n"
                + "        \"3. Last Refreshed\": \"2019-06-27 14:54:50\",\n"
                + "        \"4. Output Size\": \"Compact\",\n"
                + "        \"5. Time Zone\": \"US/Eastern\"\n"
                + "    },\n"
                + "    \"Time Series (Daily)\": {\n"
                + "        \"2019-06-27\": {\n"
                + "            \"1. open\": \"172.1200\",\n"
                + "            \"2. high\": \"172.4000\",\n"
                + "            \"3. low\": \"170.3300\",\n"
                + "            \"4. close\": \"171.1500\",\n"
                + "            \"5. volume\": \"2632971\"\n"
                + "        },\n"
                + "                         \"2019-06-28\": {\n"
                + "            \"1. open\": \"172.3200\",\n"
                + "            \"2. high\": \"172.430\",\n"
                + "            \"3. low\": \"170.3300\",\n"
                + "            \"4. close\": \"173.1500\",\n"
                + "            \"5. volume\": \"2632971\"\n"
                + "        }\n"
                + "         }\n"
                + "}\n"
                + "         ";

        TimeSeries ts = TimeSeries.fromJson(json);
        System.out.println(ts.timeUnit);
        System.out.println(ts.getUnits().size() + " units found");
        for (Unit u : ts.getUnits()) {
            System.out.println(u.getDate());
            System.out.println("close price: " + u.getClose());
        }
    }

}
