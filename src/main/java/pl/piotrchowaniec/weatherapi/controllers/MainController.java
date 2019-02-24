package pl.piotrchowaniec.weatherapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import pl.piotrchowaniec.weatherapi.models.ForecastWeatherDto;
import pl.piotrchowaniec.weatherapi.models.WeatherService;

@Controller
public class MainController {

    private final WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {

        model.addAttribute("weather", weatherService.getWeather(cityName));
        model.addAttribute("forecast", weatherService.getForecast(cityName));

//        try {
//            model.addAttribute("weather", weatherService.getWeather(cityName));
//        } catch (HttpStatusCodeException e) {
//            model.addAttribute("message", "Nie znaleziono miasta: " + cityName);
//            System.out.println("Status code: " + e.getStatusCode());
//        }

        return "index";
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public String statusCode(HttpStatusCodeException http,
                             Model model) {

        model.addAttribute("apiError", http.getStatusCode());
        System.out.println(http.getStatusCode());
//        model.addAttribute("message", "Nie znaleziono miasta");
        return "index";
    }
}