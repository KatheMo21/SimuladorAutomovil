
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
 * la clase Vehiculo, se refiere al vehículo que se va a conducir 
 * @author Katherin Monroy 
 * @version 1.0.0
 * @since 2024 10 09
 */
public class Vehiculo {
    
    /**
    * el atributo velocidad de tipo double  se refiere a la velocidad del vehiculo.
    */
    private double velocidad; 
    
    /**
    * el atributo motor de tipo Motor  se refiere al motor qur tiene el vehiculo.
    */
    private Motor motor; 
    
    ///////////////////////////////////// CONSTRUCTOR ///////////////////////////////////////////
    
    public Vehiculo (Motor motor){
        this.motor = motor; 
        this.velocidad = 0; 
    }
    //////////////////////////////////////////// METODOS DE ACCESO /////////////////////////////
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    
    ///////////////////////////////////////// METODOS /////////////////////////////////////
    
    /**
    * el método encender, valida si el vehiculo esta encendido, y si no, lo enciende.
    * @param  no recibe parámetros.
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarEncendidoException
    */
    public void encender () throws ValidarEncendidoException{
        this.motor.validarEncendido();  // validar
        this.motor.encender();
        
    }
    
    /**
    * el método apagar, valida si el vehiculo esta apagado, y si no, lo apaga.
    * @param  no recibe parámetros.
    * @return no retorna.
    * @exception se le pasa la excepcion ValidarApagadoException
    */
    public void apagar () throws ValidarApagadoException,ApagadoVelMayor60Exception{
        this.motor.validarApagado();
        validarApagadoVelocidad(); 
        this.motor.apagar();
    }
    
    /**
    * el método acelerarVehiculo valida la velocidad maxima del vehiculo
    * @param  recibe una velocidad tipo double
    * @return no retorna.
    * @exception se le pasa la excepcion LimiteMotorException
    */
    public void acelerarVehiculo(double velocidad)throws LimiteMotorException,AcelerarMotorApagadoException{
        double nVelocidad = this.velocidad + velocidad; 
        this.motor.validarAcelerado();     
        this.motor.validarVelocidadMaxima(nVelocidad);  // validar la velocidad maxima 
        this.setVelocidad(nVelocidad);
    }   
    
    /**
    * el método accidentarVehiculo valida si el vehiculo se accidenta, disminuye su velocidad a 0 y lo apaga.
    * @param  no recibe parametros
    * @return no retorna.
    */
    public void accidentarVehiculo (){
        this.setVelocidad(0);
        this.apagar();
    }
    
    
    public void validarFrenoDetenido() throws FrenarDetenidoException{
        if(this.velocidad == 0){
            throw new FrenarDetenidoException();  
        }
    }
    
    public void validarFrenoMayorVelocidad(double cantidad) throws FrenarBruscoException{
        if(cantidad > velocidad){
            throw new FrenarBruscoException();  
        }
    }
    public void validarApagadoVelocidad() throws ApagadoVelMayor60Exception{
        if(velocidad > 60 && this.motor.isEncendido()== false){
            throw new ApagadoVelMayor60Exception();
        }
    }
    
    
    /**
    * el método frenarVehiculo frena el vehiculo.
    * @param  recibe una velocidad tipo double
    * @return no retorna.
    */

    public void frenarVehiculo(double cantidad)throws FrenarMotorApagadoException,FrenarDetenidoException, FrenarBruscoException{
        this.motor.validarFrenado();
        this.validarFrenoDetenido();
        this.motor.validarFrenoBruscoLimiteLlantas(cantidad, velocidad);
        this.validarFrenoMayorVelocidad(cantidad); 
        double nVelocidad = this.velocidad - cantidad; 
        this.setVelocidad(nVelocidad);
    }
    
}
