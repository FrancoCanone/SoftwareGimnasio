
package controlador;

import baseDeDatos.PagoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import modelo.Pago;
import serial.ArduinoSerial;
import vista.DialogoAcceso;
import vista.VistaUsuario;


public class LogicaUsuario implements ActionListener {
    
    private final VistaUsuario vista;
    private Timer tiempo;
    private  ControlMolinete controlMolinete;
    private  ArduinoSerial serial;
    
    public LogicaUsuario(VistaUsuario vista){
        this.vista = vista;
        
        iniciarReloj();
        configurarCierre();
        leerDocumento();
        inicializarMolinete();
        
        //controlMolinete = new ControlMolinete(serial);
        
        
    }
    
    private void leerDocumento(){
        vista.getDniText().addActionListener( e -> verificarAcceso() );
    }
    
    private void configurarCierre(){
        vista.addWindowListener(new java.awt.event.WindowAdapter() {
            
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                
                detenerReloj();
                
            }
            
        });
    }
    
    private void inicializarMolinete(){
        
        serial = new ArduinoSerial();
        serial.conectar("COM7", 9600);
        
        controlMolinete = new ControlMolinete(serial);
    }
    
    private void iniciarReloj(){
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        
        tiempo = new Timer(1000,e ->{
           vista.getLabelHora().setText(formatoHora.format(new Date()));
        });
        
        tiempo.start();
    }
    
    private void detenerReloj(){
        
        if (tiempo != null && tiempo.isRunning()){
            tiempo.stop();
            
        }
        
    }
    
    private void verificarAcceso(){
        
        String doc = vista.getDniText().getText().trim();
        
        if(doc.isEmpty()){
            System.out.println("Ingrese un documento valido ");
        }
        
        PagoDao pago = new PagoDao();
        Pago ultimoPago = pago.obtenerUltimoPago(Integer.parseInt(doc));
        
        DialogoAcceso dialogo = new DialogoAcceso(vista);
        
        if(ultimoPago == null ){
            dialogo.mostrar("SIN REGISTRO / SIN PAGOS ",false);
            return;
        }
        
        if(ultimoPago.getFechaVencimiento().before(new Date())){
            dialogo.mostrar(" CUOTA VENCIDA ",false);
            return;
        }
        
        dialogo.mostrar("BIENVENIDO "+ultimoPago.getNombreCliente(),true);
        controlMolinete.abrirMolinete();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         
    }

}
