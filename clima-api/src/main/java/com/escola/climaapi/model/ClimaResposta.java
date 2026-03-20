package com.escola.climaapi.model;

public class ClimaResposta {
    private String tempo_zona;
    private String DataHora;
    private Double TemperaturaDia;
    private String Unidade_Temperatura_Dia;
    private Double Vento;
    private String Unidade_Vento;

    public String getTempo_zona() { return tempo_zona; }
    public String getDataHora() { return DataHora; }
    public Double getTemperaturaDia() { return TemperaturaDia; }
    public String getUnidade_Temperatura_Dia() { return Unidade_Temperatura_Dia; }
    public Double getVento() { return Vento; }
    public String getUnidade_Vento() { return Unidade_Vento; }

    public void setTempo_zona(String tempo_zona) { this.tempo_zona = tempo_zona; }
    public void setDataHora(String dataHora) { this.DataHora = dataHora; }
    public void setTemperaturaDia(Double temperaturaDia) { this.TemperaturaDia = temperaturaDia; }
    public void setUnidade_Temperatura_Dia(String unidade) { this.Unidade_Temperatura_Dia = unidade; }
    public void setVento(Double vento) { this.Vento = vento; }
    public void setUnidade_Vento(String unidade) { this.Unidade_Vento = unidade; }
}