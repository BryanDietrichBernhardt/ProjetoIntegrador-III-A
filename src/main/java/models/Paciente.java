/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bryan
 */
public class Paciente extends Pessoa {
    String endereco;

    public Paciente(String endereco, String nome, String cpf) {
        super(nome, cpf);
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return this.nome + ", " + this.cpf + ", " + this.endereco;
    }
}
