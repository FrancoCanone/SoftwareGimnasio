
package controlador;

import baseDeDatos.PagoDao;
import baseDeDatos.PlanDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Pago;
import vista.JDialogPagos;

public class LogicaPago implements ActionListener{
    
    
    private final  Pago pago;
    private final  Clientes modelo;
    private final  JDialogPagos vistaP;
    private final  PagoDao pagodao;
    private final  PlanDao planDao;
    private boolean verificarIdCliente; 
    
    
    public LogicaPago (JDialogPagos vistaP,Clientes modelo ){
        
        this.modelo = modelo;
        this.vistaP = vistaP;
        this.pagodao = new PagoDao();
        this.planDao = new PlanDao();
        this.pago = new Pago();
       
        cargarBox();
        mostrarPrecio();
        
        this.vistaP.getGuardarPago().addActionListener(this);
        this.vistaP.getVolverPago().addActionListener(this);
        this.vistaP.getBotonBuscarPago().addActionListener(this);
        
    }
    
    
    
    private void mostrarPrecio(){
        
        vistaP.getComboPlanes().addActionListener(e -> {
        String nombreSeleccionado = (String) vistaP.getComboPlanes().getSelectedItem();
        
            if (nombreSeleccionado != null) {
                
                double precio = planDao.obtenerPrecioPorNombre(nombreSeleccionado);
                vistaP.getPrecioText().setText(String.valueOf(precio));
            
            }
            
        });
        
    }
    
    private void cargarBox(){
        
        planDao.obtenerPlanes().forEach((nombrePlan) -> {
            vistaP.getComboPlanes().addItem(nombrePlan);
        });
        
    }
    
    private void buscarClientePorDni() {
        
    try {
        
        String dniTexto = vistaP.getdniTextPago().getText().trim();

        if (dniTexto.isEmpty()) {
            verificarIdCliente = false;
            vistaP.getLabelNombreApellido().setText("Ingrese un DNI");
            return;
        }

        int dni = Integer.parseInt(dniTexto);
        Clientes cliente = pagodao.buscarClientePorDni(dni);

        if (cliente != null) {
            vistaP.getLabelNombreApellido().setText(cliente.getNombre() + " " + cliente.getApellido());
            pago.setIdCliente(cliente.getIdCliente());
            vistaP.getIdLabel().setText(String.valueOf(pago.getIdCliente()));
            verificarIdCliente = true;
        } else {
            verificarIdCliente = false;
            JOptionPane.showMessageDialog(vistaP, "Cliente no encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
            vistaP.getLabelNombreApellido().setText("No encontrado");
        }

    } catch (NumberFormatException ex) {
        verificarIdCliente = false;
        vistaP.getLabelNombreApellido().setText("DNI inválido");
    } catch (HeadlessException ex) {
        verificarIdCliente = false;
        vistaP.getLabelNombreApellido().setText("Error al buscar cliente");
    }
}


    private void cargaPago(){
        
        try{
            //PLAN 
            String nombrePlan = (String)vistaP.getComboPlanes().getSelectedItem();
            int idPlan = planDao.obtenerIdPorPlan(nombrePlan);
            pago.setIdPlan(idPlan);
            
            //PRECIO DEL PLAN 
            double monto = Double.parseDouble(vistaP.getPrecioText().getText().trim());
            pago.setMonto(monto);

            //METODO PAGO
            pago.setMetodoPago(vistaP.getMetodoPagoText().getText().trim());

            //OBSERVACIONES
            pago.setObservaciones(vistaP.getObservaciones().getText().trim());

            //FECHA DE PAGO
            Date fechaPago = vistaP.getFechaDePago().getDate();
            if (fechaPago == null ){
                JOptionPane.showMessageDialog(vistaP," Debe seleccionar una fecha ");
            }

            pago.setFechaPago(fechaPago);
            
            int duracion = planDao.obtenerDuracion(nombrePlan);
            
            //FECHA DE VENCIMIENTO
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaPago);
            calendario.add(Calendar.DAY_OF_MONTH,duracion);
            Date fechaVencimiento = calendario.getTime();
            
            pago.setFechaVencimiento(fechaVencimiento);
            
            //RESULTADO

            boolean exito = pagodao.registrarPago(pago);

            if(exito){
                JOptionPane.showMessageDialog(vistaP, " Pago registrado ");

            }else{
                JOptionPane.showMessageDialog(vistaP, "Error en registrar pago ");
            }
            
        }catch (NumberFormatException e ){
            
            JOptionPane.showMessageDialog(vistaP, " verificar los campos ");
            
        }catch(HeadlessException e ){
            
            JOptionPane.showMessageDialog(vistaP, "Error en la base de datos " + e.getMessage());
            
        }
    }
    
    private void limpiarCampos(){
        
        vistaP.getMetodoPagoText().setText(" Metodo de Pago ");
        vistaP.getdniTextPago().setText(" Documento ");
        vistaP.getPrecioText().setText(" Monto ");
        vistaP.getLabelNombreApellido().setText("");
        vistaP.getIdLabel().setText("");
        vistaP.getObservaciones().setText(" Observaciones ");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object source = ae.getSource();
        
        if (source == vistaP.getGuardarPago()){
            
            if (verificarIdCliente == true ){
                
                cargaPago();
                limpiarCampos();
            
            }
                
            
        }

        
        if (source == vistaP.getVolverPago()){
            vistaP.dispose();
        }
        
        if (source == vistaP.getBotonBuscarPago()){
            buscarClientePorDni();
        }
        
    }
}
