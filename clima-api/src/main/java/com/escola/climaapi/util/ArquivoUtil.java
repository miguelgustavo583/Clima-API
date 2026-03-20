package com.escola.climaapi.util;

import com.escola.climaapi.model.ClimaResposta;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ArquivoUtil {

    public void salvarEmArquivo(ClimaResposta resposta) {
        String nomeArquivo = "clima_resultado.txt";
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write("Timezone: " + resposta.getTempo_zona() + "\n");
            writer.write("Data/Hora: " + resposta.getDataHora() + "\n");
            writer.write("Temperatura: " + resposta.getTemperaturaDia() + " " + resposta.getUnidade_Temperatura_Dia() + "\n");
            writer.write("Vento: " + resposta.getVento() + " " + resposta.getUnidade_Vento() + "\n");
            System.out.println("Salvo em arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}