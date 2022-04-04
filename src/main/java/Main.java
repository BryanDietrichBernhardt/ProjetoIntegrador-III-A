
import java.util.*;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author bryan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean control = true;
        List<Medico> medicos = new ArrayList();
        List<Paciente> pacientes = new ArrayList();
        //List<Consulta> consultas = new ArrayList();
        ListaDeConsultas listaDeConsultas = new ListaDeConsultas();
        
        while (control){
            try{
                int option = Integer.valueOf(JOptionPane.showInputDialog(null, "1 - CADASTRAR MÉDICO\n2 - CADASTRAR FUNCIONÁRIO\n3 - CRIAR CONSULTA\n4 - LISTAR CONSULTAS\n5 - LISTAR PACIENTES\n6 - LISTAR MÉDICOS\n7 - CONSULTAS POR PACIENTE\n8 - CONSULTAS POR MEDICO\n0 - SAIR\n", "MENU", 3));
                switch(option) {
                    case 1:
                        String nomeMedico = JOptionPane.showInputDialog(null, "Nome: ", "Cadastrar Médico", 3);
                        String cpfMedico = JOptionPane.showInputDialog(null, "CPF: ", "Cadastrar Médico", 3);
                        String especialidadeMedico = JOptionPane.showInputDialog(null, "Especialidade: ", "Cadastrar Médico", 3);
                        Medico medico = new Medico(especialidadeMedico, nomeMedico, cpfMedico);
                        medicos.add(medico);
                        break;
                    case 2:
                        String nomePaciente = JOptionPane.showInputDialog(null, "Nome: ", "Cadastrar Funcionário", 3);
                        String cpfPaciente = JOptionPane.showInputDialog(null, "CPF: ", "Cadastrar Funcionário", 3);
                        String enderecoPaciente = JOptionPane.showInputDialog(null, "Endereco: ", "Cadastrar Funcionário", 3);
                        Paciente paciente = new Paciente(enderecoPaciente, nomePaciente, cpfPaciente);
                        pacientes.add(paciente);
                        break;
                    case 3:
                        Paciente pacienteEscolhido = escolherPaciente(pacientes);
                        Medico medicoEscolhido = escolherMedico(medicos);
                        int identificadorConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Identificador da Consulta: ", "Cadastrar Consulta", 3));
                        int diaConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Dia: ", "Cadastrar Consulta", 3));
                        int mesConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Mês: ", "Cadastrar Consulta", 3));
                        int anoConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Ano: ", "Cadastrar Consulta", 3));
                        int horasConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Horas: ", "Cadastrar Consulta", 3));
                        int minutosConsulta = Integer.valueOf(JOptionPane.showInputDialog(null, "Minutos: ", "Cadastrar Consulta", 3));
                        DataConsulta dataConsulta = new DataConsulta(diaConsulta, mesConsulta, anoConsulta, horasConsulta, minutosConsulta);
                        Consulta consulta = new Consulta(identificadorConsulta, medicoEscolhido, pacienteEscolhido, dataConsulta);
                        //consultas.add(consulta);
                        listaDeConsultas.incluirNoFim(consulta);
                        break;
                    case 4:
                        listarConsultas(listaDeConsultas);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Pacientes: \n" + listarPacientes(pacientes));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Pacientes: \n" + listarMedicos(medicos));
                        break;
                    case 7:
                        consultasPorPaciente(listaDeConsultas);
                        break;
                    case 8:
                        consultasPorMedico(listaDeConsultas);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                        break;
                    case 0:
                        control = false;
                        break;
                }
            }
            catch(Exception exception) {
                JOptionPane.showMessageDialog(null, "Algo deu errado: " + exception);
            }
            
        }
        
    }
    
    public static Medico escolherMedico(List<Medico> medicos) {
        boolean control = true;
        Medico medicoEscolhido = new Medico("","","");
        
        while (true) {
            String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade: ", 3);
            
            String listagemDeMedicos = "";
            int contador = 0;
            List<Medico> medicosEspecialidade = new ArrayList();
            for (Medico medico : medicos){
                if (especialidade == null ? medico.especialidade == null : especialidade.equals(medico.especialidade)){
                    contador ++;
                    listagemDeMedicos += contador + "- " + medico.nome + ", " + medico.especialidade + "\n";
                    medicosEspecialidade.add(medico);
                }
            }

            if (!"".equals(listagemDeMedicos)){
                int option = Integer.valueOf(JOptionPane.showInputDialog(null, listagemDeMedicos, "Escolha o medico pelo número", 3));
                medicoEscolhido = medicosEspecialidade.get(option-1);
                break;
            }
            else {
               JOptionPane.showMessageDialog(null, "Sem médicos com essa especialidade!"); 
            }
        }
        return medicoEscolhido;
    }
    
    public static Paciente escolherPaciente(List<Paciente> pacientes) {
        String listagemDePacientes = listarPacientes(pacientes);
        int option = Integer.valueOf(JOptionPane.showInputDialog(null, listagemDePacientes, "Escolha o paciente pelo número", 3));
        return pacientes.get(option-1);
    }
    
    public static void listarConsultas(ListaDeConsultas consultas) {
        String listagemDeConsultas = "";
        
        for(int i=0; i < consultas.tamanho(); i++) {
            Consulta consultaIndice = consultas.getConsulta(i);
            listagemDeConsultas += consultaIndice.identificadorDaConsulta + "- " + consultaIndice.paciente.nome + ", " + consultaIndice.medico.nome + ", " + consultaIndice.dataConsulta.horas + ":" + consultaIndice.dataConsulta.minutos + " " + consultaIndice.dataConsulta.dia + "/" + consultaIndice.dataConsulta.mes + "/" + consultaIndice.dataConsulta.ano + "\n";
        }

        //int contador = 0;
        //for (){
        //    contador ++;
        //    listagemDeConsultas += contador + "- ID = " + consulta.identificadorDaConsulta + ", " + consulta.paciente.nome + ", " + consulta.paciente.cpf + ", " + consulta.medico.nome +"\n";
        //}
        JOptionPane.showMessageDialog(null, "Consultas: \n" + listagemDeConsultas);
    }
    
    public static String consultasPorPaciente(ListaDeConsultas consultas, List<Paciente> pacientes) {
        
        String listagemDeConsultas = "";
        String especialidade = JOptionPane.showInputDialog(null, "Digite a especialidade: ", 3);
        for(int i=0; i < consultas.tamanho(); i++) {
            Consulta consultaIndice = consultas.getConsulta(i);
            listagemDeConsultas += consultaIndice.identificadorDaConsulta + "- " + consultaIndice.paciente.nome + ", " + consultaIndice.medico.nome + ", " + consultaIndice.dataConsulta.horas + ":" + consultaIndice.dataConsulta.minutos + " " + consultaIndice.dataConsulta.dia + "/" + consultaIndice.dataConsulta.mes + "/" + consultaIndice.dataConsulta.ano + "\n";
        }
        return listagemDeConsultas;
    }
    
    public static String consultasPorMedico(ListaDeConsultas consultas) {
        String listagemDeConsultas = "";
        for(int i=0; i < consultas.tamanho(); i++) {
            Consulta consultaIndice = consultas.getConsulta(i);
            listagemDeConsultas += consultaIndice.identificadorDaConsulta + "- " + consultaIndice.paciente.nome + ", " + consultaIndice.medico.nome + ", " + consultaIndice.dataConsulta.horas + ":" + consultaIndice.dataConsulta.minutos + " " + consultaIndice.dataConsulta.dia + "/" + consultaIndice.dataConsulta.mes + "/" + consultaIndice.dataConsulta.ano + "\n";
        }
        return listagemDeConsultas;
    }
    
    public static String listarMedicos(List<Medico> medicos) {
        String listagemDeMedicos = "";
        int contador = 0;
        for (Medico medico : medicos){
            contador ++;
            listagemDeMedicos += contador + "- " + medico.nome + ", " + medico.especialidade + ", " + medico.cpf + "\n";
        }
        return listagemDeMedicos;
    }
    
    public static String listarPacientes(List<Paciente> pacientes) {
        String listagemDePacientes = "";
        int contador = 0;
        for (Paciente paciente : pacientes){
            contador ++;
            listagemDePacientes += contador + "- " + paciente.nome + ", " + paciente.cpf + ", " + paciente.endereco + "\n";
        }
        return listagemDePacientes;
    }
}