package pl.piotrchowaniec.weatherapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeatherDto {

    @JsonProperty("list")
    private List<WeatherDto> dailyForecastList;
}