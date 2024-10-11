/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 * la clase LimiteMotorException, se refiere a la clase que se usará como excepcion del limete del motor
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */
public class LimiteMotorException extends RuntimeException {
    
    
    public LimiteMotorException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("La velocidad excedió el límite permitido por el motor"); 
    }
    
    
}
