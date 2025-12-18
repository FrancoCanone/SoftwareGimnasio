
package serial;

import com.fazecast.jSerialComm.SerialPort;
import java.io.OutputStream;


public class ArduinoSerial {
    private SerialPort puerto;
    private OutputStream salida;
    
    public boolean conectar (String nombrePuerto, int baudRate){
        
        try {
            
            puerto = SerialPort.getCommPort(nombrePuerto);            
            puerto.setComPortParameters(baudRate, 8, 1, 0 );
            puerto.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
            
            if(puerto.openPort()){
                salida = puerto.getOutputStream();
                System.out.println(" Conectado "+ nombrePuerto);
                return true;
            }else{
                System.out.println(" No conectado ");
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    public void enviar(String dato){
        try{
            if (salida != null){
                salida.write(dato.getBytes());
                salida.flush();
                System.out.println(" Enviado: " +dato);
            }
                
                
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
    
    public void cerrar(){
        
        try{
            
            if(puerto != null )puerto.closePort();
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
    
}
