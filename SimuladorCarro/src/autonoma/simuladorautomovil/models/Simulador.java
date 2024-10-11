
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.AcelerarMotorApagadoException;
import autonoma.simuladorautomovil.exceptions.ApagadoVelMayor60Exception;
import autonoma.simuladorautomovil.exceptions.FrenarBruscoException;
import autonoma.simuladorautomovil.exceptions.FrenarDetenidoException;
import autonoma.simuladorautomovil.exceptions.FrenarMotorApagadoException;
import autonoma.simuladorautomovil.exceptions.LimiteMotorException;
import autonoma.simuladorautomovil.exceptions.ValidarApagadoException;
import autonoma.simuladorautomovil.exceptions.ValidarEncendidoException;

/**
 * la clase simulador, es la que conducirá el vehículo
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */
public class Simulador {
    
    /**
    * el atributo vehiculo de tipo Vehiculo  se refiere al vehiculo que manejará.
    */
    
    private Vehiculo vehiculo; 
    
    /////////////////////////////////////////////// CONSTRUCTOR ///////////////////////////////////// 
    
    public Simulador(Vehiculo vehiculo){
        this.vehiculo = vehiculo; 
    }
    //////////////////////////////////////////// METODOS DE ACCESO //////////////////////////////////

    public double getVelocidadVehiculo() {
        return vehiculo.getVelocidad();
    }
    
    
    //////////////////////////////////////////////// METODOS ///////////////////////////////////////
    /**
    * el método encenderVehiculo enciende el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarEncendidoException
    */
    public void encenderVehiculo()throws ValidarEncendidoException{
        try{  
            this.vehiculo.encender();
        }
        catch(ValidarEncendidoException e){
            throw e;
        }
    }
    
    /**
    * el método apagarVehiculo apaga el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarApagadoException
    */
    public void apagarVehiculo()throws ValidarApagadoException,ApagadoVelMayor60Exception{
        try{
           this.vehiculo.apagar(); 
        }
        catch (ValidarApagadoException e){
            throw e; 
        }
        catch(ApagadoVelMayor60Exception av){
            this.vehiculo.accidentarVehiculo();
            throw av;
        }
    }
    
    /**
    * el método acelerarVehiculo acelera el vehiculo. 
    * @param  no recibe parámetros.
    * @return no retorna.
    * @exception se le pasa la excepcion LimiteMotorException
    */
    public void acelerarVehiculo(double velocidad)throws LimiteMotorException,AcelerarMotorApagadoException{
        try{
            this.vehiculo.acelerarVehiculo(velocidad); 
        }
        catch(LimiteMotorException e){
            this.vehiculo.accidentarVehiculo();
            throw e;
        }
        catch(AcelerarMotorApagadoException a){
            throw a; 
        }
    } 
    
    public void frenarVehiculo(double cantidad)throws FrenarMotorApagadoException,FrenarDetenidoException{
        try{
            this.vehiculo.frenarVehiculo(cantidad); 
        }
        catch(FrenarMotorApagadoException a){
            throw a; 
        }
        catch (FrenarDetenidoException f){
            throw f; 
        }
        catch(FrenarBruscoException fb){
            throw fb; 
        }
        
    } 
}
