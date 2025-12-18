
package controlador;

import baseDeDatos.PagoDao;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.Pago;
import vista.JDialogPagos;
import vista.JDialogRegistrar;
import vista.JDialogTablaDatos;
import vista.JDialogPlan;
import vista.VistaAdmin; 
import vista.VistaUsuario;

public final class LogicaAdmin implements ActionListener{
 
    private final VistaAdmin vista1;
    private final Clientes modelo;
    private VistaUsuario vistaU = null;
    private LogicaUsuario logicaU = null;

    public LogicaAdmin(VistaAdmin vista, Clientes modelo) {
        
        this.vista1 = vista;
        this.modelo = modelo;
        
        mostrarTablaPagos();

        vista1.getBotonSalir().addActionListener(this);
        vista1.getBotonMostrarRegistrar().addActionListener(this);
        vista1.getBotonTabla().addActionListener(this);
        vista1.getBotonRegistrarPago().addActionListener(this);
        vista1.getBotonMembresia().addActionListener(this);
        vista1.getBotonActualizarPago().addActionListener(this);
        vista1.getVistaUsuario().addActionListener(this);
    }
    
    private void mostrarTablaPagos(){
        
        DefaultTableModel tabla = (DefaultTableModel) vista1.getTablaPagos().getModel();
        tabla.setRowCount(0); 
 
        PagoDao dao = new PagoDao();
        
        List<Pago> lista = dao.listarPagos();

        for (Pago pago : lista){
            
            tabla.addRow(new Object[]{
                
                pago.getNombreCliente(),
                pago.getApellidoCliente(),
                pago.getNombrePlan(),
                pago.getMonto(),
                pago.getFechaPago(),
                pago.getFechaVencimiento(),
                //pago.getMetodoPago(),
                pago.getObservaciones(),
                
            });
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //CREAR VARIABLE PARA BOTONES;
        Object source = ae.getSource();
        
        
        //VISTA REGISTRO DE USUARIOS;
        JDialogRegistrar registro = new JDialogRegistrar(vista1,true);
        LogicaRegistrar logicaReg = new LogicaRegistrar(registro,modelo);
        
        //VISTA TABLA DE DATOS;
        JDialogTablaDatos tabla = new JDialogTablaDatos(vista1,true);
        LogicaTabla LogicaT = new LogicaTabla(tabla,modelo);
        
        //VISTA REGISTRO PAGOS;
        JDialogPagos pagos = new JDialogPagos(vista1,true);
        LogicaPago LogicaP = new LogicaPago(pagos,modelo);
        
        //VISTA CREAR PLAN/MEMBRESIAS
        JDialogPlan membresia = new JDialogPlan(vista1,true);
        LogicaPlan logicaPL = new LogicaPlan(membresia,modelo);
        
        
        if (source == vista1.getBotonMostrarRegistrar()){ registro.setVisible(true); }
        
        if (source == vista1.getBotonActualizarPago()){ mostrarTablaPagos(); }
        
        if (source == vista1.getBotonRegistrarPago()){ pagos.setVisible(true); }
        
        if(source == vista1.getBotonMembresia()){ membresia.setVisible(true); }
        
        if (source == vista1.getBotonTabla()){ tabla.setVisible(true); }
        
        if (source == vista1.getVistaUsuario()){ 
            
            if(vistaU == null || !vistaU.isDisplayable()){
                vistaU = new VistaUsuario();
                logicaU = new LogicaUsuario(vistaU);
            }
            vistaU.setVisible(true); 
            vistaU.toFront();
        }
        
        if (source == vista1.getBotonSalir()){ System.exit(0); }
    }
}