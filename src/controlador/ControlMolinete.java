
package controlador;

import java.util.Timer;
import java.util.TimerTask;
import serial.ArduinoSerial;


public class ControlMolinete {
    
    private final ArduinoSerial serial;
    
    public ControlMolinete(ArduinoSerial serial){
        this.serial = serial;
        
    }
    
    public void abrirMolinete(){
        
        serial.enviar("1"); // Abrir molinete
        
        new Timer().schedule(new TimerTask(){
            
            @Override
            public void run(){
                serial.enviar("0"); // Cerrar molinete
            }
            
        },3000); //segundos 1 = 1000
        
    }
    
}
