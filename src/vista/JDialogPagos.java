package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;




public class JDialogPagos extends javax.swing.JDialog {

    private final String PLACEHOLDER_METODOPAGO = " Metodo de Pago " ;
    private final String PLACEHOLDER_DOCUMENTO = " Documento " ;
    private final String PLACEHOLDER_OBSERVACIONES = " Observaciones ";
    
    
    public JDialogPagos(java.awt.Frame parent, boolean modal) {
        
        
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        ajusteJTextField();
        quitarFocoConClick();
        editarMonto();
        
        
        SwingUtilities.invokeLater(()->{
            this.requestFocusInWindow();
        });
        
        
        
    }
    
    private void editarMonto(){
        
        precioText.setEditable(false);
        
    }
    
    private void quitarFocoConClick() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                requestFocusInWindow();
            }
        });
    }
    
    private void ajusteJTextField(){
        
        setupPlaceholder(metodoPagoText,PLACEHOLDER_METODOPAGO);
        setupPlaceholder(dniTextPago,PLACEHOLDER_DOCUMENTO);
        setupPlaceholder(observacionesText,PLACEHOLDER_OBSERVACIONES);
    
    }
    
    
    private void setupPlaceholder(JTextField field,String placeholder){
        
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
        jPanel2 = new javax.swing.JPanel();
        comboBoxPlanes = new javax.swing.JComboBox<>();
        fechaDePago = new com.toedter.calendar.JDateChooser();
        dniTextPago = new javax.swing.JTextField();
        TextoFechaDelPago = new javax.swing.JLabel();
        labelNombreApellido = new javax.swing.JLabel();
        metodoPagoText = new javax.swing.JTextField();
        guardarPago = new javax.swing.JButton();
        volverPago = new javax.swing.JButton();
        buscarDniPago = new javax.swing.JButton();
        observacionesText = new javax.swing.JTextField();
        precioText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboBoxPlanes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        comboBoxPlanes.setBorder(new javax.swing.border.MatteBorder(null));
        comboBoxPlanes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(comboBoxPlanes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        fechaDePago.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.add(fechaDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 130, -1));

        dniTextPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dniTextPago.setText(" Documento");
        dniTextPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(dniTextPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        TextoFechaDelPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TextoFechaDelPago.setText("Fecha del pago:");
        jPanel2.add(TextoFechaDelPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 127, 22));

        labelNombreApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(labelNombreApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 30));

        metodoPagoText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        metodoPagoText.setText("Metodo de Pago");
        metodoPagoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(metodoPagoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 140, 30));

        guardarPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        guardarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar2.png"))); // NOI18N
        guardarPago.setText("Guardar");
        guardarPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        guardarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(guardarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 80, 30));

        volverPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        volverPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-return-20.png"))); // NOI18N
        volverPago.setText("Volver");
        volverPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        volverPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(volverPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 80, 30));

        buscarDniPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-search-20.png"))); // NOI18N
        buscarDniPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));
        buscarDniPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(buscarDniPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 30, 20));

        observacionesText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        observacionesText.setText("Observaciones");
        observacionesText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(observacionesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 40));

        precioText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        precioText.setText("Monto");
        precioText.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(precioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 20, 20));

        idLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 70, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 390));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText(" Registro Pago");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //hacer publicos componentes faltantes 
    
    public JLabel getLabelNombreApellido(){ return labelNombreApellido; }
    
    public JLabel getIdLabel(){ return idLabel; }
    
    public JTextField getdniTextPago(){ return dniTextPago; }
    
    public JComboBox getComboPlanes(){ return comboBoxPlanes; }
    
    public JTextField getMetodoPagoText() {return metodoPagoText; }
    
    public JTextField getPrecioText(){ return precioText;}
    
    public JDateChooser getFechaDePago(){ return fechaDePago; }
    
    public JDateChooser getFechaDeVencimiento() { return fechaDePago; }
    
    public JButton getVolverPago(){ return volverPago; }

    public JButton getGuardarPago(){ return guardarPago; }
    
    public JButton getBotonBuscarPago(){ return buscarDniPago; }
    
    public JTextField getObservaciones() { return observacionesText; } 
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextoFechaDelPago;
    private javax.swing.JButton buscarDniPago;
    private javax.swing.JComboBox<String> comboBoxPlanes;
    private javax.swing.JTextField dniTextPago;
    private com.toedter.calendar.JDateChooser fechaDePago;
    private javax.swing.JButton guardarPago;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelNombreApellido;
    private javax.swing.JTextField metodoPagoText;
    private javax.swing.JTextField observacionesText;
    private javax.swing.JTextField precioText;
    private javax.swing.JButton volverPago;
    // End of variables declaration//GEN-END:variables
}
