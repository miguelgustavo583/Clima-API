package com.escola.climaapi.controler;

import com.escola.climaapi.model.ClimaResposta;
import com.escola.climaapi.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping
    public ClimaResposta getClima(
            @RequestParam BigDecimal latitude,
            @RequestParam BigDecimal longitude) {

        return climaService.buscarClima(latitude, longitude);
    }
}
