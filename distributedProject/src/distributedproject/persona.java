/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject;


import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 *
 * @author mario
 */
public class persona implements Serializable {
    String nombre;
    double altura, peso, IMC;
    
    
   public persona(String nombre,double altura, double peso){
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
    }
    
    public double calcularIMC(){
        IMC =(peso/(altura*altura));
        return IMC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + '}';
    }

    
}
