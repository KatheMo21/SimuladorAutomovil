
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author Katherin
 */
public class FrenarBruscoException extends RuntimeException{
    
    public FrenarBruscoException(){
        // el suoper hacer referencia a la clase padre( contructor)
        super("El vehículo patinará"); 
    }
}
