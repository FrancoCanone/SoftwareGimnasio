
package controlador;

import baseDeDatos.ClienteDao;
import baseDeDatos.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Clientes;
import vista.JDialogTablaDatos;


public class LogicaTabla implements ActionListener{
    
    private final Clientes modelo;
    private final JDialogTablaDatos vistaT;
    private final ClienteDao clienteDao;
    private TableRowSorter<DefaultTableModel> sorter;
    
    public LogicaTabla(JDialogTablaDatos vistaT, Clientes modelo){
        
        this.modelo = modelo;
        this.vistaT = vistaT;
        this.clienteDao = new ClienteDao();
        
        mostrarClientes(); 
        agregarBuscador();
        
        this.vistaT.getBotonActualizar().addActionListener(this);
        this.vistaT.getBotonVolverTabla().addActionListener(this);
        this.vistaT.getBotonGuardar().addActionListener(this);
    }
    
    private Vector<String> getColumnNames(DefaultTableModel model) {
        Vector<String> columnNames = new Vector<>();
        
        for (int i = 0; i < model.getColumnCount(); i++) {
            columnNames.add(model.getColumnName(i));
        }
        
        return columnNames;
    }
    
    
    private void mostrarClientes() {
        
        DefaultTableModel tabla = (DefaultTableModel) vistaT.getActualizarTabla().getModel();
        tabla.setRowCount(0);
        
        tabla = new DefaultTableModel(tabla.getDataVector(), getColumnNames(tabla)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 3;
            }
        };
        
        String sql = "SELECT  idCliente, nombre, apellido, dni, numeroCelular, peso, altura, direccion, observaciones, ocupacion, actividadPrevia, fechaNac, fechaIngreso  FROM cliente";

        
        try (Connection con = Conexion.getConexion();
                
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                
                DecimalFormat df = new DecimalFormat("0.00");
                
                // Obtener la fecha de nacimiento
                java.sql.Date fechaNac = rs.getDate("fechaNac");

                // Calcular la edad actual
                int edad = 0;
                
                if (fechaNac != null) {
                    java.time.LocalDate nacimiento = fechaNac.toLocalDate();
                    java.time.LocalDate hoy = java.time.LocalDate.now();
                    edad = java.time.Period.between(nacimiento, hoy).getYears();
                }
            
                Object[] fila = {
                    
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    edad,
                    rs.getInt("dni"),
                    rs.getLong("numeroCelular"),
                    df.format(rs.getFloat("peso")),
                    df.format(rs.getFloat("altura")),
                    rs.getString("direccion"),
                    rs.getString("observaciones"),
                    rs.getString("ocupacion"),
                    rs.getString("actividadPrevia"),
                    rs.getDate("fechaNac"),
                    rs.getDate("fechaIngreso"),
                    
                };  
                
                tabla.addRow(fila);
                
            }

            vistaT.getActualizarTabla().setModel(tabla);
            sorter = new TableRowSorter<>(tabla);
            vistaT.getActualizarTabla().setRowSorter(sorter);
            vistaT.tamañoCasilla();

        } catch (SQLException e) {
            
            System.out.println(" Error al mostrar clientes: " + e.getMessage());
        }
    }
    
    private void agregarBuscador() {
        
        vistaT.getTextBuscar().getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) { filtrar(); }

            @Override
            public void removeUpdate(DocumentEvent e) { filtrar(); }

            @Override
            public void changedUpdate(DocumentEvent e) { filtrar(); }

            private void filtrar() {
                
                String texto = vistaT.getTextBuscar().getText().trim();
                if (texto.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("^" + texto, 4)); 
                }
                
            }
            
        });
        
    }
    
    private void modificarClientes(){
        
        int fila = vistaT.getActualizarTabla().getSelectedRow();
        
        if (fila == -1){
            JOptionPane.showMessageDialog(vistaT, " seleccione una fila ");
            
        }
        
        int filaReal = vistaT.getActualizarTabla().convertRowIndexToModel(fila);
        
        DefaultTableModel tabla =(DefaultTableModel) vistaT.getActualizarTabla().getModel();
        
        int idCliente = Integer.parseInt(tabla.getValueAt(filaReal,0).toString());
        String nombre = tabla.getValueAt(filaReal,1).toString();
        String apellido = tabla.getValueAt(filaReal,2).toString();
        int dni = Integer.parseInt(tabla.getValueAt(filaReal, 4).toString());
        long numeroCelular = Long.parseLong(tabla.getValueAt(filaReal,5).toString());
        float peso = Float.parseFloat(tabla.getValueAt(filaReal, 6).toString().replace(",", "."));
        float altura = Float.parseFloat(tabla.getValueAt(filaReal, 7).toString().replace(",", "."));
        String direccion = tabla.getValueAt(filaReal, 8).toString();
        String observaciones = tabla.getValueAt(filaReal, 9).toString();
        String ocupacion = tabla.getValueAt(filaReal, 10).toString();
        String actividadPrevia = tabla.getValueAt(filaReal, 11).toString();
        
        Object valorNac = tabla.getValueAt(filaReal,12);
        Object valorIngreso = tabla.getValueAt(filaReal,13);
        
        java.sql.Date fechaNac = null;
        java.sql.Date fechaIngreso = null; 
        
        if (valorNac instanceof java.sql.Date) {
            
            fechaNac = (java.sql.Date) valorNac;
            
        } else if (valorNac instanceof String && !((String) valorNac).isEmpty()) {
            
            fechaNac = java.sql.Date.valueOf((String) valorNac);
        }

        if (valorIngreso instanceof java.sql.Date) {
            fechaIngreso = (java.sql.Date) valorIngreso;
        } else if (valorIngreso instanceof String && !((String) valorIngreso).isEmpty()) {
            fechaIngreso = java.sql.Date.valueOf((String) valorIngreso);
        }

        boolean exito = clienteDao.actualizarCliente(idCliente, nombre, apellido, dni, numeroCelular, peso, altura, direccion, observaciones, ocupacion, actividadPrevia, fechaNac, fechaIngreso);
    
        if (exito){
            JOptionPane.showMessageDialog(vistaT, " Cambios Guardados. ");
        }else{
             JOptionPane.showMessageDialog(vistaT, " Ocurrio un error. ");
        }
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //CREAR VARIABLE PARA BOTONES 
        Object source = ae.getSource();
        
        
        if ( source == vistaT.getBotonVolverTabla()){
            vistaT.dispose();
        }
        
        if (source == vistaT.getBotonActualizar()){
            mostrarClientes();
        }
        
        if (source == vistaT.getBotonGuardar()){
            modificarClientes();
           
        }
        
        
    }
    
}
