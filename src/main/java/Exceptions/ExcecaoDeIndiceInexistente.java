/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author bryan
 */
public class ExcecaoDeIndiceInexistente extends IndexOutOfBoundsException {
    @Override
    public String getMessage() {
        return "Índice inexistente na lista!";
    }
}
