package com.microweather.mvn_report.controller;


import com.microweather.mvn_report.service.DataClient;
import com.microweather.mvn_report.service.WeatherReportService;
import com.microweather.mvn_report.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Weather Report Controller.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

	@Autowired
	private WeatherReportService weatherReportService;
	
	@Autowired
	private DataClient dataClient;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		List<City> cityList = null;
		
		try {
			
			// 由城市数据API微服务提供数据
			cityList = dataClient.listCity();
			
		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		
		model.addAttribute("title", "邮电大学的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		System.out.println(weatherReportService.getDataByCityId(cityId).getCity());
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
