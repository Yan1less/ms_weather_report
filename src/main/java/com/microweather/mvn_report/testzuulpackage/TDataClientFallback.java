package com.microweather.mvn_report.testzuulpackage;

import com.microweather.mvn_report.vo.City;
import com.microweather.mvn_report.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TDataClientFallback implements  TDataClient{


    private final static Logger logger = LoggerFactory.getLogger(TDataClientFallback.class);


    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        logger.info("use fallback   ----by rikka");
        return null;
    }
}
