package pl.piotrchowaniec.weatherapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    @JsonProperty("main")
    private WeatherParameters weatherParameters;

    private Clouds clouds;

    @JsonProperty("dt_txt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Data
    public static class WeatherParameters {
        private double temp;
        private int humidity;
    }

    @Data
    public static class Clouds {
        private int all;
    }
}