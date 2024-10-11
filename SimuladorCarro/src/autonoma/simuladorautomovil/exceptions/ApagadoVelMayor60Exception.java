/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author Katherin
 */
public class ApagadoVelMayor60Exception extends RuntimeException{
    
    public ApagadoVelMayor60Exception(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo va a mas de 60 Km/h, no se puede apagar"); 
    }
}
