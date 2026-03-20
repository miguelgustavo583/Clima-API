package com.escola.climaapi.service;

import com.escola.climaapi.model.ClimaResposta;
import com.escola.climaapi.util.ArquivoUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;

@Service
public class ClimaService {

    @Autowired
    private ArquivoUtil arquivoUtil;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ClimaResposta buscarClima(BigDecimal latitude, BigDecimal longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + latitude
                + "&longitude=" + longitude
                + "&current_weather=true"
                + "&timezone=auto";
        try {
            String json = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(json);

            ClimaResposta resposta = new ClimaResposta();
            resposta.setTempo_zona(root.path("timezone").asText());

            JsonNode currentWeather = root.path("current_weather");
            resposta.setDataHora(currentWeather.path("time").asText());
            resposta.setTemperaturaDia(currentWeather.path("temperature").asDouble());
            resposta.setUnidade_Temperatura_Dia(
                    root.path("current_weather_units").path("temperature").asText("°C")
            );
            resposta.setVento(currentWeather.path("windspeed").asDouble());
            resposta.setUnidade_Vento(
                    root.path("current_weather_units").path("windspeed").asText("km/h")
            );

            arquivoUtil.salvarEmArquivo(resposta);

            return resposta;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clima: " + e.getMessage());
        }
    }
}