
package vista;


import javax.swing.JButton;
import javax.swing.JTable;
import estilos.BotonPersonalizado;




public final class VistaAdmin extends javax.swing.JFrame {
    
    

    
    
    public VistaAdmin() {
        
        initComponents();
        setLocationRelativeTo(null);
        editarLabel();
        

        
        BotonPersonalizado botonPersonalizado  = new BotonPersonalizado("");
        botonPersonalizado .setBounds(botonMostrarRegistrar.getBounds()); 
        botonPersonalizado .setIcon(botonMostrarRegistrar.getIcon()); 
        botonPersonalizado .setCursor(botonMostrarRegistrar.getCursor());

        jPanel1.remove(botonMostrarRegistrar); // quitamos el anterior
        jPanel1.add(botonPersonalizado , 
            new org.netbeans.lib.awtextra.AbsoluteConstraints(
                botonMostrarRegistrar.getX(), 
                botonMostrarRegistrar.getY(),
                botonMostrarRegistrar.getWidth(), 
                botonMostrarRegistrar.getHeight()
            )
        );

        botonMostrarRegistrar = botonPersonalizado ; 
        
        
        
        BotonPersonalizado botonPago = new BotonPersonalizado("");
        botonPago.setBounds(botonRegistrarPago.getBounds()); 
        botonPago.setIcon(botonRegistrarPago.getIcon()); 
        botonPago.setCursor(botonRegistrarPago.getCursor());

        jPanel1.remove(botonRegistrarPago); 
        jPanel1.add(botonPago, 
            new org.netbeans.lib.awtextra.AbsoluteConstraints(
                botonRegistrarPago.getX(), 
                botonRegistrarPago.getY(),
                botonRegistrarPago.getWidth(), 
                botonRegistrarPago.getHeight()
            )
        );
        
        botonRegistrarPago = botonPago; 
        
        BotonPersonalizado botonPlan = new BotonPersonalizado("");
        botonPlan.setBounds(botonMembresia.getBounds()); 
        botonPlan.setIcon(botonMembresia.getIcon()); 
        botonPlan.setCursor(botonMembresia.getCursor());

        jPanel1.remove(botonMembresia); 
        jPanel1.add(botonPlan, 
            new org.netbeans.lib.awtextra.AbsoluteConstraints(
                botonMembresia.getX(), 
                botonMembresia.getY(),
                botonMembresia.getWidth(), 
                botonMembresia.getHeight()
            )
        );
        
        botonMembresia = botonPlan; 
        
                
        
        BotonPersonalizado botonT = new BotonPersonalizado("");
        botonT.setBounds(botonTabla.getBounds()); 
        botonT.setIcon(botonTabla.getIcon()); 
        botonT.setCursor(botonTabla.getCursor());

        jPanel1.remove(botonTabla); 
        jPanel1.add(botonT, 
            new org.netbeans.lib.awtextra.AbsoluteConstraints(
                botonTabla.getX(), 
                botonTabla.getY(),
                botonTabla.getWidth(), 
                botonTabla.getHeight()
            )
        );
        
        botonTabla = botonT; 
        
        BotonPersonalizado botonUser = new BotonPersonalizado("");
        botonUser.setBounds(botonVistaUsuario.getBounds());
        botonUser.setIcon(botonVistaUsuario.getIcon());
        botonUser.setCursor(botonVistaUsuario.getCursor());
        
        jPanel1.remove(botonVistaUsuario);
        jPanel1.add(botonUser, 
            new org.netbeans.lib.awtextra.AbsoluteConstraints(
                botonVistaUsuario.getX(), 
                botonVistaUsuario.getY(),
                botonVistaUsuario.getWidth(), 
                botonVistaUsuario.getHeight()
            )
        );
        
        botonVistaUsuario= botonUser;
        
        jPanel1.revalidate();
        jPanel1.repaint();
        
    }
    
    
    
    public void editarLabel(){
        jLabel1.setText("<html>REGISTRO<br> CLIENTE <html>");
        jLabel2.setText("<html>REGISTRO<br> PAGO <html>");
        jLabel4.setText("<html>MEMBRESIA<html>");
        jLabel3.setText("<html>MOSTRAR<br> CLIENTES <html>");
        txtUsuario.setText("<html> Vista<br> Usuario <html>");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        botonTabla = new javax.swing.JButton();
        botonRegistrarPago = new javax.swing.JButton();
        botonMostrarRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonMembresia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonVistaUsuario = new javax.swing.JButton();
        txtUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        actualizarTablaPago = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInicio.setBackground(new java.awt.Color(204, 204, 255));
        panelInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInicio.setFocusCycleRoot(true);
        panelInicio.setFocusTraversalPolicyProvider(true);
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonSalir.setText("Cerrar");
        botonSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelInicio.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 540, 70, 27));

        jPanel1.setBackground(new java.awt.Color(30, 144, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonTabla.setBackground(new java.awt.Color(255, 255, 255));
        botonTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-database-administrator-50.png"))); // NOI18N
        botonTabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonTabla.setContentAreaFilled(false);
        botonTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonTabla.setOpaque(true);
        jPanel1.add(botonTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 70, 70));

        botonRegistrarPago.setBackground(new java.awt.Color(255, 255, 255));
        botonRegistrarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cash-in-hand-60.png"))); // NOI18N
        botonRegistrarPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonRegistrarPago.setContentAreaFilled(false);
        botonRegistrarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarPago.setOpaque(true);
        jPanel1.add(botonRegistrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, 70));

        botonMostrarRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        botonMostrarRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-register-64.png"))); // NOI18N
        botonMostrarRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonMostrarRegistrar.setContentAreaFilled(false);
        botonMostrarRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMostrarRegistrar.setOpaque(true);
        jPanel1.add(botonMostrarRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(botonMostrarRegistrar);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setLabelFor(botonRegistrarPago);
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 70, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setLabelFor(botonTabla);
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, 30));

        botonMembresia.setBackground(new java.awt.Color(255, 255, 255));
        botonMembresia.setForeground(new java.awt.Color(255, 255, 255));
        botonMembresia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-member-card-50 (1).png"))); // NOI18N
        botonMembresia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonMembresia.setContentAreaFilled(false);
        botonMembresia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMembresia.setOpaque(true);
        jPanel1.add(botonMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 70, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setLabelFor(botonMembresia);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 70, 30));

        botonVistaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        botonVistaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-access-50.png"))); // NOI18N
        botonVistaUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(botonVistaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 70, 70));

        txtUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 70, 30));

        panelInicio.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 130));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelInicio.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1260, 30));

        actualizarTablaPago.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        actualizarTablaPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar2.png"))); // NOI18N
        actualizarTablaPago.setText("Actualizar");
        actualizarTablaPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        actualizarTablaPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelInicio.add(actualizarTablaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 90, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Cuotas Vencidas");
        panelInicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        tablaPagos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaPagos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Plan", "Monto", "Fecha de Pago", "Vencimiento", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPagos.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablaPagos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaPagos);

        jScrollPane2.setViewportView(jScrollPane1);

        panelInicio.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 620, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    
    //----------------- BOTONES ----------------------------------------//
     
    public JButton getBotonSalir(){return botonSalir;}
    
    public JButton getBotonMostrarRegistrar(){return botonMostrarRegistrar;}
   
    public JButton getBotonTabla(){ return botonTabla; }
    
    public JTable getTablaPagos(){ return tablaPagos; }
    
    public JButton getBotonRegistrarPago(){ return botonRegistrarPago; }
    
    public JButton getBotonMembresia(){ return botonMembresia;}
    
    public JButton getBotonActualizarPago(){ return actualizarTablaPago; }
    
    public JButton getVistaUsuario(){ return botonVistaUsuario;}
    
    
    //------------------------------------------------------------------//
    
    
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarTablaPago;
    private javax.swing.JButton botonMembresia;
    private javax.swing.JButton botonMostrarRegistrar;
    private javax.swing.JButton botonRegistrarPago;
    public javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTabla;
    private javax.swing.JButton botonVistaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

    
}
