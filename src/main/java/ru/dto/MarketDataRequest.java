package ru.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.entity.Securities;
import ru.enums.TimeFrame;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
public class MarketDataRequest {
    private String startDate;
    private String endDate;
    private Securities securities;
    private TimeFrame timeFrame;

    @JsonIgnore
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd  HH:mm:ss");

    @JsonIgnore
    public Long getStartDateTimeStamp() {
        return converterStringToTimeStamp(startDate);
    }

    @JsonIgnore
    public Long getEndDateTimeStamp() {
        return converterStringToTimeStamp(endDate);
    }

    public Long converterStringToTimeStamp(String strDate) {
        return Timestamp.valueOf(LocalDateTime.parse(strDate, formatter)).getTime();
    }



}
