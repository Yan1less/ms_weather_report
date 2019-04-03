package com.microweather.mvn_report.service;


import com.microweather.mvn_report.vo.Weather;
import com.microweather.mvn_report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private DataClient dataClient;
	@Override
	public Weather getDataByCityId(String cityId) {
		
		// 由天气数据API微服务来提供
		WeatherResponse resp = dataClient.getDataByCityId(cityId);

		Weather data = null;
		if (resp != null ) {
			data = resp.getData();
		}
		return data;
	}

}
