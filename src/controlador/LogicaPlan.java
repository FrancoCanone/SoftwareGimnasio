
package controlador;

import baseDeDatos.PlanDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Plan;
import modelo.Clientes;
import vista.JDialogPlan;
import vista.JDialogCargaPlan;


public class LogicaPlan implements ActionListener {
    
    private final Clientes modelo;
    private final Plan plan;
    private final PlanDao planDao;
    private final JDialogPlan vistaPL;
    private  JDialogCargaPlan vistaPLC;
    
    
    
    public LogicaPlan(JDialogPlan vistaPL, Clientes modelo ){
        
        this.modelo = modelo;
        this.vistaPL= vistaPL;
        this.plan = new Plan();
        planDao = new PlanDao();
        
        
        mostrarTablaMem();
        
        this.vistaPL.getBotonVolver().addActionListener(this);
        this.vistaPL.getBotonBorrar().addActionListener(this);
        this.vistaPL.getBotonNuevo().addActionListener(this);
        this.vistaPL.getBotonActualizar().addActionListener(this);
        this.vistaPL.getBotonModificar().addActionListener(this);
    }
    
    private void mostrarTablaMem(){
                
        DefaultTableModel tabla = (DefaultTableModel) vistaPL.getTabla().getModel();
        tabla.setRowCount(0);
        
        PlanDao pl = new PlanDao();
        
        List<Plan> listaM = pl.listarMembresias();
        
        for(Plan p : listaM){
            tabla.addRow(new Object[]{
                p.getIdPlan(),
                p.getNombrePlan(),
                p.getMonto(),
                p.getDias(),
            });
    
        }
        
        vistaPL.tamañoCasilla();
       
    }
    
    public void guardarPlan() {
        
        String nombre = vistaPLC.getNombrePlan().getText().trim();
        String montoStr = vistaPLC.getMonto().getText().trim();
        String duracionStr = vistaPLC.getDuracion().getText().trim();

        if (nombre.isEmpty() || montoStr.isEmpty() || duracionStr.isEmpty()) {
            JOptionPane.showMessageDialog(vistaPLC, "Por favor complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Double monto = Double.parseDouble(montoStr);
            int dias = Integer.parseInt(duracionStr);

            Plan plan = new Plan();

            plan.setNombrePlan(nombre);
            plan.setMonto(monto);
            plan.setDias(dias);

            PlanDao dao = new PlanDao();
            dao.insertarPlan(plan);
            

            JOptionPane.showMessageDialog(vistaPLC, "Plan registrado correctamente.");
            mostrarTablaMem();

            vistaPLC.getNombrePlan().setText("");
            vistaPLC.getMonto().setText("");
            vistaPLC.getDuracion().setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vistaPLC, "Monto y duración deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void borrarPlan(){
        
        PlanDao pl = new PlanDao();
        
        String input = JOptionPane.showInputDialog(vistaPL, "Ingrese el ID del plan que desea eliminar:");

        if (input != null && !input.trim().isEmpty()) {
            
            try {
                int idPlan = Integer.parseInt(input.trim());

                int confirmacion = JOptionPane.showConfirmDialog(
                        vistaPL,
                        "¿Seguro que deseas eliminar el plan con ID " + idPlan + "?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    pl.eliminarPlan(idPlan);
                    mostrarTablaMem();
                    JOptionPane.showMessageDialog(vistaPL, "Plan eliminado correctamente.");
                     
                } else {
                    JOptionPane.showMessageDialog(vistaPL, "Eliminación cancelada.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vistaPL, "Por favor ingrese un número válido de ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vistaPL, "No se ingresó ningún ID.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void modificarPlan(){
        int fila = vistaPL.getTabla().getSelectedRow();
        
        if(fila == -1){
            JOptionPane.showMessageDialog(vistaPL," Error ");
        }
        
        int filaReal = vistaPL.getTabla().convertRowIndexToModel(fila);
                
        DefaultTableModel tabla = ( DefaultTableModel ) vistaPL.getTabla().getModel();
        
        int idPlan = Integer.parseInt(tabla.getValueAt(filaReal,0).toString());
        String nombrPlan = tabla.getValueAt(filaReal, 1).toString();
        Double precio = Double.parseDouble(tabla.getValueAt(filaReal, 2).toString().replace(",","."));
        int duracion = Integer.parseInt(tabla.getValueAt(filaReal, 3).toString());
        
        boolean exito = planDao.actualizarPlan(idPlan,nombrPlan, precio, duracion);
        
        if (exito){
            JOptionPane.showMessageDialog(vistaPL," Cambios Guardados ");
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object source = ae.getSource();
        
        
        
        if (source == vistaPL.getBotonNuevo()) {
            
            vistaPLC = new JDialogCargaPlan(vistaPL, true);
            LogicaCargaPlan logicaCarga = new LogicaCargaPlan(vistaPLC, this);
            vistaPLC.setDefaultCloseOperation(javax.swing.JDialog.DISPOSE_ON_CLOSE);
            vistaPLC.setVisible(true);
        }
        
        if (source == vistaPL.getBotonVolver()){
            vistaPL.dispose();
        }
        
        if (source == vistaPL.getBotonModificar()){
            modificarPlan();
        }
        
        if (source == vistaPL.getBotonBorrar()){
            borrarPlan();
        }
            
        if (source == vistaPL.getBotonActualizar()){
            mostrarTablaMem();
        }
    }
}
