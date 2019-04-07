# ms_weather_report

目前最终的消费者

使用方式：report/cityId/{cityId}
     report/cityName/{cityName}
会远程调用data的数据，进行封装美化，返回给用户一个界面
舍友服务熔断服务降级，在调用不通的时候，会给用户呈现一些静态的数据
