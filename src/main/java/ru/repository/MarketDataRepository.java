package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dto.MarketDataBarEntity;
import ru.enums.TimeFrame;

import java.util.List;

@Repository
public interface MarketDataRepository extends JpaRepository<MarketDataBarEntity, Long> {

    List<MarketDataBarEntity> findAllBySecuritiesIdAndTimeFrameAndDateTimeBetween
            (Long securitiesId, TimeFrame timeFrame,Long startTimeStamp, Long endTimeStamp);
}
