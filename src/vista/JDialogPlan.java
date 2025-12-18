
package vista;

import javax.swing.JButton;
import javax.swing.JTable;


public class JDialogPlan extends javax.swing.JDialog {


    public JDialogPlan(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        
    }
    
    public void tamañoCasilla(){
        
        int [] anchos = {5, 50, 50 , 30 };
        
        JTable tabla =  tablaMembresias;
        
        for (int i = 0; i < anchos.length && i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonModificar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonNuevo = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMembresias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar2.png"))); // NOI18N
        botonModificar.setText("Guardar Cambios");
        botonModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificar.setHideActionText(true);
        botonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 30));

        botonBorrar.setBackground(new java.awt.Color(255, 255, 255));
        botonBorrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-trash-20.png"))); // NOI18N
        botonBorrar.setText("Borrar");
        botonBorrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(botonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 80, 30));

        botonNuevo.setBackground(new java.awt.Color(255, 255, 255));
        botonNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar2.png"))); // NOI18N
        botonNuevo.setText("Cargar");
        botonNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonNuevo.setInheritsPopupMenu(true);
        jPanel1.add(botonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 80, 30));

        botonActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar2.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 90, 30));

        botonVolver.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-return-20.png"))); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 80, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMembresias.setBorder(new javax.swing.border.MatteBorder(null));
        tablaMembresias.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tablaMembresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID ", "Plan", "Precio", "Duracion (Dias)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMembresias);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 220));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 540, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //--------------------------------------------------------------------------//
    
    public JButton getBotonVolver(){ return botonVolver;}
    public JButton getBotonBorrar(){ return botonBorrar;}
    public JButton getBotonActualizar(){ return botonActualizar;}
    public JButton getBotonModificar(){ return botonModificar;}
    public JButton getBotonNuevo(){ return botonNuevo; }
    public JTable getTabla(){ return tablaMembresias; }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMembresias;
    // End of variables declaration//GEN-END:variables
}
