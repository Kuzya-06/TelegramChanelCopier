package ru.dto;


import lombok.Data;
import ru.entity.Securities;
import ru.enums.TimeFrame;


import java.util.TreeSet;

@Data
public class MarketDataDto {
    private TreeSet<MarketDataBar> bars;
    private Securities securities;
    private TimeFrame timeFrame;


    public MarketDataDto(){
        this.bars = new TreeSet<>();
    }
}
