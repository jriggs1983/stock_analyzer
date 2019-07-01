package com.jriggs.stock_analyzer.jsonentity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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



}
