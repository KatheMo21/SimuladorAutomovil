
package autonoma.simuladorautomovil.exceptions;

/**
 * la clase ValidarApagadoException, se refiere a la clase que se usará como excepcion para validar el apagado del vehículo
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */
public class ValidarApagadoException extends RuntimeException {
    
    public ValidarApagadoException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo ya está apagado, no se puede volver a apagar"); 
    } 
    
}
