package ru.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MarketDataBar implements Comparable<MarketDataBar> {
    private double open;
    private double high;
    private double low;
    private double close;

    private double volume;
    private double average;
    private long barCount;
    private boolean hasGaps;
    private String date;

    @JsonIgnore
    private boolean isDateConverted = false;

    @JsonIgnore
    private LocalDateTime localDateTime;

    public MarketDataBar() {
    }

    public MarketDataBar(double open, double high, double low, double close) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public MarketDataBar(MarketDataBar bar) {
        this.open = bar.open;
        this.high = bar.high;
        this.low = bar.low;
        this.close = bar.close;

        this.volume = bar.volume;
        this.average = bar.average;
        this.barCount = bar.barCount;
        this.hasGaps = bar.hasGaps;
        this.date = bar.date;
    }

    @JsonIgnore
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd  HH:mm:ss");


    @Override
    public int compareTo(MarketDataBar p) {
        return (-1)*date.compareTo(p.getDate());
    }




//    public LocalDateTime getDateTime(){
//        if(!isDateConverted){
//            localDateTime = LocalDateTime.parse(date, formatter);
//            isDateConverted = true;
//        }
//        return localDateTime;
//    }


    public MarketDataBar add(MarketDataBar bar1, MarketDataBar bar2) {
        this.open = bar1.open + bar2.open;
        this.high = bar1.high + bar2.high;
        this.low = bar1.low + bar2.low;
        this.close = bar1.close + bar2.close;

        this.volume = bar1.volume;
        this.average = bar1.average;
        this.barCount = bar1.barCount;
        this.hasGaps = bar1.hasGaps;
        this.date = bar1.date;
        return this;
    }

    public MarketDataBar multiply(double koef) {
        this.open = this.open * koef;
        this.high = this.high * koef;
        this.low = this.low * koef;
        this.close = this.close * koef;
        return this;
    }

    public MarketDataBar divide(double koef) {
        this.open = this.open / koef;
        this.high = this.high / koef;
        this.low = this.low / koef;
        this.close = this.close / koef;
        return this;
    }

    public MarketDataBar divide(MarketDataBar bar2) {
        this.open = bar2.open;
        this.high = bar2.high;
        this.low = bar2.low;
        this.close = bar2.close;
        return this;
    }

}
