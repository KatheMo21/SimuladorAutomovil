
package autonoma.simuladorautomovil.exceptions;

/**
 * la clase ValidarEncendidoException, se refiere a la clase que se usará como excepcion para validar el encendido del vehículo
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */

public class ValidarEncendidoException extends RuntimeException {
    
    public ValidarEncendidoException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo ya está encendido, no se puede volver a encender"); 
    }
}
