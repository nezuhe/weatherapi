package pl.piotrchowaniec.weatherapi.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CheckWeatherJob {

    final WeatherService weatherService;
    final SmsService smsService;
    final static String CITY_NAME = "Kraków";

    @Autowired
    public CheckWeatherJob(SmsService smsService, WeatherService weatherService) {
        this.smsService = smsService;
        this.weatherService = weatherService;
    }

//    @Scheduled(fixedRate = 1000 * 60 * 2)
//    public void checkWeather() {
//        WeatherDto weather = weatherService.getWeather(CITY_NAME);
//        smsService.sendSms(CITY_NAME + " - Aktualna temperatura: " + weather.getWeatherParameters().getTemp(),
//                "507063681");
//        smsService.sendSms(CITY_NAME + " - Aktualna temperatura: " + weather.getWeatherParameters().getTemp(),
//                "690417090");
//    }
}
