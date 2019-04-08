package com.microweather.mvn_report.testzuulpackage;

import com.microweather.mvn_report.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="msa-weather-city-eureka", fallback=CityClientFallback.class)
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
