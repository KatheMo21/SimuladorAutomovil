/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.AcelerarMotorApagadoException;
import autonoma.simuladorautomovil.exceptions.FrenarBruscoException;
import autonoma.simuladorautomovil.exceptions.FrenarMotorApagadoException;
import autonoma.simuladorautomovil.exceptions.LimiteMotorException;
import autonoma.simuladorautomovil.exceptions.ValidarApagadoException;
import autonoma.simuladorautomovil.exceptions.ValidarEncendidoException;

/**
 * la clase motor, se refiere al motor que tiene el vehiculo
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */
public class Motor {
    
     
    /**
    * el atributo cilindraje de tipo int  se refiere al cilindraje del motor.
    */
    private int cilindraje; 
    
    /**
    * el atributo encendido de tipo boolean muestra si el motor esta encendido o no.
    */
    private boolean encendido; 
    
    /**
    * el atributo velocidadMaxima de tipo double  se refiere a la velocidad maxima que soporta el motor.
    */
    private double velocidadMaxima; 
    
    
    ///////////////////////////////////// CONSTRUCTOR /////////////////////////////////////
    
    public Motor ( double velocidadMaxima, int cilindraje){
        this.encendido = false; 
        this.velocidadMaxima = velocidadMaxima; 
        this.cilindraje = cilindraje; 
        
    }
    
    /////////////////////////////////////// METODOS DE ACCESO /////////////////////////////

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    
    //////////////////////////////////////// METODOS ////////////////////////////////////////7
    
    /**
    * el método encender enciende el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    */
    public void encender(){
        this.encendido = true; 
    }
    
    /**
    * el método apagar apaga el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    */
    public void apagar(){
        this.encendido = false; 
    }
    
    /**
    * el método frenar frena el vehiculo el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    */
    public void frenar(){
        this.encendido = false; 
    }
    
    
    /**
    * el método validarVelocidadMaxima valida la velocidad maxima que soporta el motor 
    * @param  recibe como parametros velocidad tipo double
    * @return no retorna.
    * @exception se le pasa la excepcion LimiteMotorException
    */
    public void validarVelocidadMaxima(double velocidad) throws LimiteMotorException{
        if (velocidad > this.velocidadMaxima){
            throw new LimiteMotorException(); 
        }
    }
    
    /**
    * el método validarEncendido valida si el motor ya esta encendido 
    * @param  no recibe parametros 
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarEncendidoException
    */
    public void validarEncendido() throws ValidarEncendidoException{
        if (this.encendido == true){
            throw new ValidarEncendidoException(); 
        }
    }
    
    /**
    * el método validarApagado valida si el motor ya esta apagado
    * @param  no recibe parametros 
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarApagadoException
    */
    public void validarApagado() throws ValidarApagadoException{
        if (this.encendido == false){
            throw new ValidarApagadoException(); 
        }
    }
    
    /**
    * el método validarfrenado valida si el motor frena
    * @param  no recibe parametros 
    * @return no retorna.
     * @throws se le pasa la excepcion ValidarApagadoException y FrenarMotorApagadoException
    */
    public void validarFrenado() throws FrenarMotorApagadoException{
        if (this.encendido == false){
            throw new FrenarMotorApagadoException(); 
        }
    }
    
    /**
    * el método validarAcelerado valida si el motor acelera
    * @param  no recibe parametros 
    * @return no retorna.
     * @throws se le pasa la excepcion ValidarApagadoException y FrenarMotorApagadoException
    */
    public void validarAcelerado() throws AcelerarMotorApagadoException{
        if (this.encendido == false){
            throw new AcelerarMotorApagadoException(); 
        }
    }
    
    public boolean frenarBrusco(double cantidad) {
        if(cantidad > 30){
            return true; 
        }
        return false; 
    }
    
    public void validarFrenoBruscoLimiteLlantas(double cantidad,double velocidad){
        if(frenarBrusco(cantidad) && velocidad > this.velocidadMaxima){
            throw new FrenarBruscoException(); 
        }
    }
   
    
    
}
