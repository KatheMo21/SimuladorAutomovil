/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.exceptions.LimiteMotorException;
import autonoma.simuladorautomovil.models.*; // truco para no tener que importar todo 

/**
 *
 * @author Katherin
 */
public class DemoSimuladorApp {
    
    public static void main(String[] args) {
        
        Motor motor  = new Motor(200,2000); 
        Vehiculo vehiculo = new Vehiculo(motor); 
        Simulador simulador = new Simulador(vehiculo); 
        
        simulador.encenderVehiculo();
        try{

        simulador.acelerarVehiculo(50);
        System.out.println(simulador.getVelocidadVehiculo());
        simulador.acelerarVehiculo(140);
        }
        catch(LimiteMotorException e){
            System.out.println("VEHICULO ACCIDENTADO - HA SOBREPASADO LA VELOCIDAD PERMITIDA");
            System.exit(0); 
        }
        
        System.out.println("Has acelerado el vehículo exitosamente");
        
        // encender el vehiculo cuando ya esta encendido 
        simulador.encenderVehiculo();
        simulador.apagarVehiculo();
    }
}
