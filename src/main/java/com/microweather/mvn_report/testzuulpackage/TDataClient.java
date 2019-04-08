package com.microweather.mvn_report.testzuulpackage;

import com.microweather.mvn_report.service.DataClientFallback;
import com.microweather.mvn_report.vo.City;
import com.microweather.mvn_report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msa-weather-data-eureka", fallback=TDataClientFallback.class)
public interface TDataClient {



    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
