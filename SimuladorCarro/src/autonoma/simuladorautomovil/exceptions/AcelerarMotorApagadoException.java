/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author Katherin
 */
public class AcelerarMotorApagadoException  extends RuntimeException{
    
    public AcelerarMotorApagadoException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo esta apagado, no se puede acelerar"); 
    }
}