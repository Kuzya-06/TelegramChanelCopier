package ru.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.enums.TimeFrame;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "market_data_bar")
public class MarketDataBarEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private Long dateTime;

    @Column(name = "open")
    private Double open;

    @Column(name = "close")
    private Double close;

    @Column(name = "high")
    private Double high;

    @Column(name = "low")
    private Double low;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "average")
    private Double average;

    @Column(name = "bar_count")
    private Long barCount;

    @Column(name = "has_gaps")
    private Boolean hasGaps;




    @Column(name="securities_id")
    private Long securitiesId;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_frame")
    private TimeFrame timeFrame;

    public MarketDataBarEntity() {
    }

    public MarketDataBarEntity(Long securitiesId, MarketDataBar bar, TimeFrame timeFrame) {
//        this.dateTime = Timestamp.valueOf(bar.getDateTime()).getTime();
        this.open = bar.getOpen();
        this.close = bar.getClose();
        this.high = bar.getHigh();
        this.low = bar.getLow();
        this.volume = bar.getVolume();
        this.average = bar.getAverage();
        this.barCount = bar.getBarCount();
        this.hasGaps = bar.isHasGaps();
        this.securitiesId = securitiesId;
        this.timeFrame = timeFrame;
    }

    public MarketDataBar getMarketDataBar() {
        MarketDataBar bar = new MarketDataBar();
        bar.setOpen(this.getOpen());
        bar.setClose(this.getClose());
        bar.setHigh(this.getHigh());
        bar.setLow(this.getLow());
        bar.setVolume(this.getVolume());
        bar.setAverage(this.getAverage());
        bar.setBarCount(this.getBarCount());
        bar.setHasGaps(this.getHasGaps());


        bar.setDate(Instant.ofEpochMilli(this.getDateTime()).toString());

        return bar;
    }

}
