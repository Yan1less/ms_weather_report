package com.microweather.mvn_report.testzuulpackage;

import com.microweather.mvn_report.controller.WeatherReportController;
import com.microweather.mvn_report.service.WeatherReportService;
import com.microweather.mvn_report.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/withoutzuul")
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private TDataClient dataclient;

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // 获取城市ID列表
        List<City> cityList = null;

        try {

            // 由城市数据API微服务提供数据
            cityList = cityClient.listCity();

        } catch (Exception e) {
            logger.error("Exception!  ", e);
        }

        model.addAttribute("title", "没有使用网关的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", dataclient.getDataByCityId(cityId).getData());
        System.out.println(dataclient.getDataByCityId(cityId).getData().getCity());
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
