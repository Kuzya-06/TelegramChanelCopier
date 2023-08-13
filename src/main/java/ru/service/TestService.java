package ru.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dto.MarketDataBar;
import ru.dto.MarketDataBarEntity;
import ru.dto.MarketDataDto;
import ru.dto.MarketDataRequest;
import ru.repository.MarketDataRepository;
import ru.repository.SecuritiesRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final MarketDataRepository marketDataRepository;
    private final SecuritiesRepository securitiesRepository;

    @PostConstruct
    public void init() {

               //readData();
    }

    public MarketDataDto readData() {


        try {
            ObjectMapper mapper = new ObjectMapper();
            MarketDataDto marketDataDto = mapper.readValue(new File("src/main/resources/AUDCAD_1min_1W.json"), MarketDataDto.class);

            List<MarketDataBarEntity> barEntityList = new ArrayList<>();
            for (MarketDataBar bar : marketDataDto.getBars()) {
                barEntityList.add(new MarketDataBarEntity(marketDataDto.getSecurities().getId(), bar, marketDataDto.getTimeFrame()));
            }
            marketDataRepository.saveAll(barEntityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
