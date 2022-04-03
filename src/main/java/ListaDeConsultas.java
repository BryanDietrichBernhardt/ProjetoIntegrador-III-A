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
}
