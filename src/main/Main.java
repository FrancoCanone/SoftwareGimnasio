
package main;

import vista.VistaAdmin;
import modelo.Clientes;
import controlador.LogicaAdmin;
import com.fazecast.jSerialComm.SerialPort;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Main {

    public static void main(String[] args){
        
        
        try {
            
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatLightLaf());
            
        } catch (UnsupportedLookAndFeelException ex) {
            
            System.err.println("Error al aplicar el tema FlatLaf: " + ex.getMessage());
            
        }
    
        
        //revisar puerto del arduino 
        SerialPort[] puertos = SerialPort.getCommPorts();
        System.out.println(" Puertos Disponibles: ");
        
        for(SerialPort p : puertos ){
            System.out.println( p.getSystemPortName()+ " - " + p.getDescriptivePortName() );
        }
        
        
        
        //crear vista, modelo y controlador
        VistaAdmin vistaInicio = new VistaAdmin();
        
        Clientes modelo = new Clientes();
        
        LogicaAdmin controlador = new LogicaAdmin(vistaInicio, modelo);

        //Connection conexion = Conexion.getConexion();
        
        //vista Visible
        vistaInicio.setVisible(true);
        
        
    }
    
    
    
}
