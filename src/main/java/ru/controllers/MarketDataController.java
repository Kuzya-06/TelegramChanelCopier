package ru.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dto.MarketDataBarEntity;
import ru.dto.MarketDataDto;
import ru.dto.MarketDataRequest;
import ru.entity.Securities;
import ru.repository.SecuritiesRepository;
import ru.service.MarketDataService;

import java.util.List;
import java.util.Optional;

//  http://localhost:8091/swagger-ui.html


@RestController
//@RequestMapping
@RequestMapping("/api") // смотри public class MarketDataStorageApplication (.paths(PathSelectors.ant("/api/*")))
@RequiredArgsConstructor
@Api(tags = "Получение рыночных данных")
public class MarketDataController {

    private final MarketDataService marketDataService;
    private final SecuritiesRepository securitiesRepository;

    /**
     * Каждые 10 минут от клиентов приходит отчет
     */
//    @RequestMapping(value = "/licenceCheck", method = RequestMethod.GET)
//    public LicenceStatus licenceCheck(@RequestBody LicenceCheckEntity licenceCheckEntity) {
//        return licenceCheckService.licenceCheck(licenceCheckEntity);
//    }
    @PostMapping("/getMarketData")
    public MarketDataDto getMarketData(@RequestBody MarketDataRequest marketDataRequest) {
        return marketDataService.getData(marketDataRequest);
    }

    @PostMapping("/getMarket")
    public List<MarketDataBarEntity> getMarket(@RequestBody MarketDataRequest market) {
        return marketDataService.getMarket(market);
    }

    // Для проверки сваггер
    @GetMapping("/{id}")
    public Securities getGet(@PathVariable(value = "id")Long id){
        Optional<Securities> byId = securitiesRepository.findById(id);
        return byId.orElse(null);
    }

}