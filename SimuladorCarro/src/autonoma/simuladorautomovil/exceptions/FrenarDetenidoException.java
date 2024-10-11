/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author Katherin
 */
public class FrenarDetenidoException  extends RuntimeException{
    
    public FrenarDetenidoException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo esta detenido, el freno no surge efecto"); 
    }
}