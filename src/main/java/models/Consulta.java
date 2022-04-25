/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bryan
 */
public class Consulta {
    int identificadorDaConsulta;
    Medico medico;
    Paciente paciente;
    DataConsulta dataConsulta;
    Consulta proximo;

    public Consulta(int identificadorDaConsult, Medico medico, Paciente paciente, DataConsulta dataConsulta) {
        this.identificadorDaConsulta = identificadorDaConsult;
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
    }

    public int getIdentificadorDaConsult() {
        return identificadorDaConsulta;
    }

    public void setIdentificadorDaConsult(int identificadorDaConsult) {
        this.identificadorDaConsulta = identificadorDaConsult;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DataConsulta getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(DataConsulta dataConsulta) {
        this.dataConsulta = dataConsulta;
    }  
    
    @Override
    public String toString() {
        return "--- Consulta ID " + String.valueOf(this.identificadorDaConsulta) + " ---" + "\n" +
                "Paciente: " + this.paciente.toString() + "\n" +
                "Medico: " + this.medico.toString() + "\n" +
                "Data: " + this.dataConsulta.toString() + "\n";
    }
}
