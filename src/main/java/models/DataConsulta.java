/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bryan
 */
public class DataConsulta {
    int dia;
    int mes;
    int ano;
    int horas;
    int minutos;

    public DataConsulta(int dia, int mes, int ano, int horas, int minutos) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.horas = horas;
        this.minutos = minutos;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.dia) + "/" + String.valueOf(this.mes) + "/" + String.valueOf(this.ano) + " " + String.valueOf(this.horas) + ":" + String.valueOf(this.minutos);
    }
}
