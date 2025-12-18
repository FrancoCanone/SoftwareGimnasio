
package vista;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class JDialogTablaDatos extends javax.swing.JDialog {
    
    private final String PLACEHOLDER_BUSCAR = " Buscar Por DNI ";

    public JDialogTablaDatos(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
        quitarFocoConClick();
        ajusteTextField();
        noElegirCasilla();
        
        
        
    }
    
    private void detectarCambios(){
        
        //JTableMostrarBDD.addTableModelListener(e ->{
            //getBotonGuardar().setEnabled(true);
        //});
       
    }
    
    public void tamañoCasilla(){
        
        int [] anchos = {22, 100, 100, 18, 35, 40, 20, 10, 100, 80, 60, 60, 40, 40  };
        
        JTable tabla =  JTableMostrarBDD;
        
        for (int i = 0; i < anchos.length && i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
       
  
    }
    
    private void noElegirCasilla(){
        SwingUtilities.invokeLater(()->{
            this.requestFocusInWindow();
        });
    }
    
    private void quitarFocoConClick() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                requestFocusInWindow();
            }
        });
    }
    
    private void ajusteTextField(){
        setupPlaceholder(filtrarTabla,PLACEHOLDER_BUSCAR);
    }
    
    private void setupPlaceholder(JTextField field, String placeholder){
        
        field.setText(placeholder);
        field.setForeground(Color.BLACK);
        
        field.addFocusListener(new FocusAdapter (){
            
            @Override
            public void focusGained(FocusEvent e){
                if (field.getText().equals(placeholder)){
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (field.getText().trim().isEmpty()){
                    field.setForeground(Color.BLACK);
                    field.setText(placeholder);
                }
                
            }
            
        });
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        botonVolverTabla = new javax.swing.JButton();
        filtrarTabla = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableMostrarBDD = new javax.swing.JTable();
        guardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelTabla.setBorder(new javax.swing.border.MatteBorder(null));
        panelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar2.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTabla.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 92, 25));

        botonVolverTabla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonVolverTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-return-20.png"))); // NOI18N
        botonVolverTabla.setText("Volver");
        botonVolverTabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonVolverTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTabla.add(botonVolverTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 410, 80, 26));

        filtrarTabla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        filtrarTabla.setText(" Filtrar por DNI");
        filtrarTabla.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelTabla.add(filtrarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 147, 26));

        JTableMostrarBDD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTableMostrarBDD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JTableMostrarBDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Edad", "Documento", "Celular", "Peso", "Altura", "Direccion", "Observacion", "Ocupacion", "Actividad Previa", "Fecha de Nacimiento", "Ingreso"
            }
        ));
        jScrollPane1.setViewportView(JTableMostrarBDD);

        jScrollPane2.setViewportView(jScrollPane1);

        panelTabla.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, 1266, 349));

        guardarCambios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        guardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar2.png"))); // NOI18N
        guardarCambios.setText("Guardar Cambios");
        guardarCambios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        guardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTabla.add(guardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 130, 31));

        jPanel1.add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1310, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public JButton getBotonActualizar(){ return botonActualizar; }
    public JButton getBotonVolverTabla(){ return botonVolverTabla; }
    public JButton getBotonGuardar(){ return guardarCambios; }
    public JTable getActualizarTabla(){ return JTableMostrarBDD;}
    public JTextField getTextBuscar(){ return filtrarTabla;}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableMostrarBDD;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonVolverTabla;
    private javax.swing.JTextField filtrarTabla;
    private javax.swing.JButton guardarCambios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelTabla;
    // End of variables declaration//GEN-END:variables
}
