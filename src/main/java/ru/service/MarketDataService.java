package ru.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dto.MarketDataBarEntity;
import ru.dto.MarketDataDto;
import ru.dto.MarketDataRequest;
import ru.repository.MarketDataRepository;
import ru.repository.SecuritiesRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketDataService {

    private final MarketDataRepository marketDataRepository;
    private final SecuritiesRepository securitiesRepository;

    @PostConstruct
    public void init() {
        //     MarketDataRequest marketDataRequest = new MarketDataRequest();

        //    getData(marketDataRequest);
    }

    /**
     * запрашиваем рыночные данные в базе, если какие-то данные отсутствуют, то запрашиваем из БрокерСервис
     */
    public MarketDataDto getData(MarketDataRequest marketDataRequest) {

        MarketDataDto result = new MarketDataDto();
        //запрашиваем данные из базы
        List<MarketDataBarEntity> marketDataBarEntityList =
                marketDataRepository.findAllBySecuritiesIdAndTimeFrameAndDateTimeBetween
                        (marketDataRequest.getSecurities().getId(),
                                marketDataRequest.getTimeFrame(),
                                marketDataRequest.getStartDateTimeStamp(),
                                marketDataRequest.getEndDateTimeStamp());

        for (MarketDataBarEntity entity : marketDataBarEntityList) {
            result.getBars().add(entity.getMarketDataBar());
        }

        result.setSecurities(marketDataRequest.getSecurities());
        result.setTimeFrame(marketDataRequest.getTimeFrame());


        // нужно проверить, есть ли такие данные в базе market_data_bar

//        if (true) {
//
//        } else {
//
//        }
//
//        //
//

        try {

//            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,  String.class);
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(responseEntity.getBody());
//            String name = root.path("ul").path(0).path("snippet_string").textValue();
//            System.out.println(name);
//
//
//            ResponseEntity<Company> responseCompanyEntity = restTemplate.exchange(url, HttpMethod.GET, null,  Company.class);
//            Company company = responseCompanyEntity.getBody();
//            System.out.println(company.getSuccess());

//            System.out.println(company.getUl().get(0).);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MarketDataBarEntity> getMarket(MarketDataRequest marketDataRequest) {
        return marketDataRepository.findAll();
    }
}
