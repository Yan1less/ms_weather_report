/**
 * 
 */
package com.microweather.mvn_report.service;


import com.microweather.mvn_report.vo.City;
import com.microweather.mvn_report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * DataClient Fallback.
 * 
 * @since 1.0.0 2017年12月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Component
public class DataClientFallback implements DataClient {

	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101280301");
		city.setCityName("惠州");
		cityList.add(city);
		
		return cityList;
	}

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		System.out.println("rongduan");
		return null;
	}

}
