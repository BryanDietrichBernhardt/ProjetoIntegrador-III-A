
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bryan
 */
public class ListaDeConsultas {
    Consulta inicio;
    
    public ListaDeConsultas() {
        this.inicio = null;
    }
    
    
    public void incluirNoInicio(Consulta consulta){
        // Move o nodo do primeiro indice da lista para o proximo indice
        consulta.proximo = this.inicio;
        // Armazena o nodo criado para o primeiro indice da lista
        this.inicio = consulta;
    }
    
    public void incluirNoFim(Consulta consulta){
        // Verifica se a lista está vazia
        if (this.inicio != null) {
            Consulta ultimoElemento = this.inicio;
            while (ultimoElemento.proximo != null) {
                ultimoElemento = ultimoElemento.proximo;
            }
            ultimoElemento.proximo = consulta;
        }
        else {
            this.inicio = consulta;
        }
    }
    
    public void removerDoFim(Consulta consulta){
        Consulta atual = this.inicio;
        while (atual.proximo != null) {
            Consulta proximo = atual.proximo;
            
            if (proximo.proximo == null) {
                atual.proximo = null;
            }
            else {
                atual = atual.proximo;
            }
        }
    }
    
    public int tamanho(){
        Consulta atual = this.inicio;
        int tamanho = 0;
        
        // Verifica se está vazia
        if (this.inicio == null) {
            return 0;
        }
        else if (atual.paciente != null && atual.proximo == null) {
            return 1;
        }
        while (atual != null) {
            tamanho += 1;
            atual = atual.proximo;
        }
        return tamanho;
    }
    
    public Consulta getConsulta(int indice){
        Consulta atual = this.inicio;
        int posicaoAtual = 0;
        if (posicaoAtual == indice) {
            return this.inicio;
        }
        else {
            while (atual != null) {
                if (posicaoAtual == indice) {
                    break;
                }
                atual = atual.proximo;
                posicaoAtual ++;
            }
        }
        return atual;
    }
    
    public Consulta[] insertionSort() {
        Consulta vetor[] = new Consulta[this.tamanho()];
        Consulta atual = this.inicio;
        int posicaoAtual = 0;
        if (this.inicio == null) {
            System.out.println("Lista vazia!");
        } else {
            while (atual != null) {
                vetor[posicaoAtual] = atual;
                posicaoAtual += 1;
                atual = atual.proximo;
            }
        }
        
        
        int j;
        Consulta key;
        int i;
        
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].dataConsulta.ano > key.dataConsulta.ano); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].dataConsulta.mes > key.dataConsulta.mes) && (vetor[i].dataConsulta.ano == key.dataConsulta.ano); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].dataConsulta.dia > key.dataConsulta.dia) && (vetor[i].dataConsulta.ano == key.dataConsulta.ano) && (vetor[i].dataConsulta.mes == key.dataConsulta.mes); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].dataConsulta.horas > key.dataConsulta.horas) && (vetor[i].dataConsulta.ano == key.dataConsulta.ano) && (vetor[i].dataConsulta.mes == key.dataConsulta.mes) && (vetor[i].dataConsulta.dia == key.dataConsulta.dia); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].dataConsulta.minutos > key.dataConsulta.minutos) && (vetor[i].dataConsulta.ano == key.dataConsulta.ano) && (vetor[i].dataConsulta.mes == key.dataConsulta.mes) && (vetor[i].dataConsulta.dia == key.dataConsulta.dia) && (vetor[i].dataConsulta.horas == key.dataConsulta.horas); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        return vetor;
    }
    
    public String consultasPorPaciente(ListaDeConsultas consultas, List<Paciente> pacientes) {
        Consulta[] vetor = this.insertionSort();
        
        ListaDeConsultas listaDeConsultas = new ListaDeConsultas();
        
        String listagemDeConsultas = "";
        String paciente = JOptionPane.showInputDialog(null, "Digite o nome do paciente: ", "Nome do paciente", 3);
        for(int i=0; i < vetor.length; i++) {
            Consulta consultaIndice = vetor[i];
            if (paciente == null ? consultaIndice.paciente.nome == null : paciente.equals(consultaIndice.paciente.nome)){
                listagemDeConsultas += consultaIndice.toString() + "\n";
            }
        }
        return listagemDeConsultas;
    }
    
    public String consultasPorMedico(ListaDeConsultas consultas, List<Medico> medicos) {
        Consulta[] vetor = this.insertionSort();
        String listagemDeConsultas = "";
        String medico = JOptionPane.showInputDialog(null, "Digite o nome do médico: ", "Nome do médico", 3);
        for(int i=0; i < vetor.length; i++) {
            Consulta consultaIndice = vetor[i];
            if (medico == null ? consultaIndice.medico.nome == null : medico.equals(consultaIndice.medico.nome)){
                listagemDeConsultas += consultaIndice.toString() + "\n";
            }
        }
        return listagemDeConsultas;
    }
}
