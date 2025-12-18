package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JDialogRegistrar extends javax.swing.JDialog {
    
    private final String PLACEHOLDER_NOMBRE = " Nombre ";
    private final String PLACEHOLDER_DNI = " Documento ";
    private final String PLACEHOLDER_OBSERVACIONES = " Observaciones ";
    private final String PLACEHOLDER_APELLIDO = " Apellido ";
    private final String PLACEHOLDER_CELULAR = " Numero de Telefono ";
    private final String PLACEHOLDER_PESO = " Peso ";
    private final String PLACEHOLDER_ALTURA = " Altura ";
    private final String PLACEHOLDER_DIRECCION = " Direccion ";
    private final String PLACEHOLDER_OCUPACION = " Ocupacion ";
    private final String PLACEHOLDER_ACTIVIDADPREVIA = " Actividad Previa ";
    
    public JDialogRegistrar(java.awt.Frame parent, boolean modal) {
        
        
        
        super(parent, modal);
        initComponents();
        
        ajusteJTextField();
        setLocationRelativeTo(null);
        quitarFocoConClick();
        
        noElegirCasilla();
        editarEdad();
  
       
        
        
    }
    
    private void editarEdad(){
        
        edadText.setEditable(false);
        
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
    
    private int calcularEdad(Date fechaNac) {
        
        LocalDate nacimiento = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento, hoy).getYears();
    }
    
    
    private void ajusteJTextField(){
        
        setupPlaceholder(nombreText,PLACEHOLDER_NOMBRE);
        setupPlaceholder(apellidoText,PLACEHOLDER_APELLIDO);
        setupPlaceholder(documentoText,PLACEHOLDER_DNI);
        setupPlaceholder(celularText,PLACEHOLDER_CELULAR);
        setupPlaceholder(observacionesText,PLACEHOLDER_OBSERVACIONES);
        setupPlaceholder(pesoText, PLACEHOLDER_PESO);
        setupPlaceholder(alturaText, PLACEHOLDER_ALTURA);
        setupPlaceholder(direccionText,PLACEHOLDER_DIRECCION);
        setupPlaceholder(ocupacionText,PLACEHOLDER_OCUPACION);
        setupPlaceholder(actividadPrevText,PLACEHOLDER_ACTIVIDADPREVIA);
        
        
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
        if(field == apellidoText()){
            apellidoText.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(java.awt.event.KeyEvent e){
                
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) ){
                        e.consume();
                        //Toolkit.getDefaultToolkit().beep();
                    }
                    
                }
            });
        }
        
        if (field == nombreText){
            
            

            nombreText.addKeyListener(new java.awt.event.KeyAdapter(){
            
                @Override
                public void keyTyped(java.awt.event.KeyEvent e){
                
                    char c = e.getKeyChar();
                    if(Character.isDigit(c)){
                        e.consume();
                        
                    }
                }
            });
            
        }
        
        if (field == celularText){ 
        
            celularText.addKeyListener(new java.awt.event.KeyAdapter(){

                @Override
                public void keyTyped(java.awt.event.KeyEvent e){
                    char c = e.getKeyChar();
                    if(!Character.isDigit(c) || celularText.getText().length() >= 10){
                        e.consume();
                        
                    }
                }

            });
        }
        if (field == documentoText){
            documentoText.addKeyListener(new java.awt.event.KeyAdapter() {
            
                @Override
                public void keyTyped (java.awt.event.KeyEvent e ){
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)){
                        e.consume();
                        
                    }
                    
                }
            
            });
        }
        
        
        
        if ( field == alturaText || field == pesoText ){
            
            field.addKeyListener(new java.awt.event.KeyAdapter() {  
                
                @Override
                public void keyTyped(KeyEvent e ){
                    
                    char c = e.getKeyChar();
                    
                    if (!Character.isDigit(c) && c!= '.' && c!=',' && !Character.isISOControl(c)){
                        e.consume();
                        return;
                    }
                    
                    if ((c == '.' || c == ',') && (field.getText().contains(".") || field.getText().contains(","))){
                        e.consume();
                        return;
                    }
                    
                    if (field.getText().length()>=5 && !Character.isISOControl(c)){
                        e.consume();
                    }
                }
  
            });
        }   
    }
    
    public void limpiarCampos(){
       
        nombreText.setText(PLACEHOLDER_NOMBRE);
        apellidoText.setText(PLACEHOLDER_APELLIDO);
        documentoText.setText(PLACEHOLDER_DNI);
        edadText.setText("");
        observacionesText.setText(PLACEHOLDER_OBSERVACIONES);
        celularText.setText(PLACEHOLDER_CELULAR);
        pesoText.setText(PLACEHOLDER_PESO);
        alturaText.setText(PLACEHOLDER_ALTURA);
        ocupacionText.setText(PLACEHOLDER_OCUPACION);
        direccionText.setText(PLACEHOLDER_DIRECCION);
        actividadPrevText.setText(PLACEHOLDER_ACTIVIDADPREVIA);
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCargaDeDatos = new javax.swing.JPanel();
        nombreText = new javax.swing.JTextField();
        documentoText = new javax.swing.JTextField();
        observacionesText = new javax.swing.JTextField();
        celularText = new javax.swing.JTextField();
        apellidoText = new javax.swing.JTextField();
        pesoText = new javax.swing.JTextField();
        alturaText = new javax.swing.JTextField();
        actividadPrevText = new javax.swing.JTextField();
        direccionText = new javax.swing.JTextField();
        botonCargarDatos = new javax.swing.JButton();
        fechaNacText = new com.toedter.calendar.JDateChooser();
        fechaIngresoText = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ocupacionText = new javax.swing.JTextField();
        botonVolverRegistrar = new javax.swing.JButton();
        edadText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCargaDeDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelCargaDeDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelCargaDeDatos.setFocusCycleRoot(true);
        panelCargaDeDatos.setFocusTraversalPolicyProvider(true);
        panelCargaDeDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreText.setText("Nombre");
        nombreText.setToolTipText("");
        nombreText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(nombreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        documentoText.setText("Documento");
        documentoText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(documentoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        observacionesText.setText("Observaciones");
        observacionesText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(observacionesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 40));

        celularText.setText("Numero de Telefono");
        celularText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(celularText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, -1));

        apellidoText.setText("Apellido");
        apellidoText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(apellidoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, -1));

        pesoText.setText("Peso");
        pesoText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(pesoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        alturaText.setText("Altura");
        alturaText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(alturaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));

        actividadPrevText.setText("Actividad Previa");
        actividadPrevText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(actividadPrevText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, -1));

        direccionText.setText("Direccion");
        direccionText.setToolTipText("");
        direccionText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(direccionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, -1));

        botonCargarDatos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCargarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar2.png"))); // NOI18N
        botonCargarDatos.setText("Guardar");
        botonCargarDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonCargarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelCargaDeDatos.add(botonCargarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 90, 30));

        fechaNacText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(fechaNacText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 150, -1));

        fechaIngresoText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(fechaIngresoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 150, -1));

        jLabel2.setText("Fecha de Nacimiento:");
        panelCargaDeDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 130, 20));

        jLabel3.setText("Fecha de Ingreso:");
        panelCargaDeDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 20));

        ocupacionText.setText("Ocupacion");
        ocupacionText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(ocupacionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, -1));

        botonVolverRegistrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonVolverRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-return-20.png"))); // NOI18N
        botonVolverRegistrar.setText("Volver");
        botonVolverRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        botonVolverRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelCargaDeDatos.add(botonVolverRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, 30));

        edadText.setText("Edad");
        edadText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panelCargaDeDatos.add(edadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 150, -1));

        jPanel1.add(panelCargaDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 340, 380));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText(" REGISTRO DE USUARIOS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //-----------------JPANELS/LAYERED------------------------------------------//
    
    public JPanel getPanelCargaDatos(){ return panelCargaDeDatos; }
    
    
    //----------------- BOTONES ----------------------------------------//
        
    public JButton getBotonCargarDatos(){return botonCargarDatos;}
    
    public JButton getBotonVolverRegistrar(){return botonVolverRegistrar;}
    
    
    //-------------- INGRESO DE DATOS desde VISTA ----------------------------------//
    
    public JTextField nombreText(){ return nombreText; }
    
    public JTextField apellidoText(){ return apellidoText; }
    
    public JTextField documentoText(){ return documentoText; }
    
    public JTextField celularText(){ return celularText; }
    
    public JTextField observacionesText(){ return observacionesText; }
    
    public JTextField pesoText(){ return pesoText; }
    
    public JTextField alturaText(){ return alturaText; }
    
    public JTextField ocupacionText(){ return ocupacionText; }
    
    public JTextField direcccionText(){ return direccionText; }
    
    public JDateChooser fechaIngresoText(){ return fechaIngresoText; }
    
    public JDateChooser fechaNacText(){ return fechaNacText; }
    
    public JTextField actividadPrevText(){ return actividadPrevText;}
    
    public JTextField edadText(){return edadText; }
    
    
    
    
   
    //------------------------------------------------------------------//
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actividadPrevText;
    private javax.swing.JTextField alturaText;
    private javax.swing.JTextField apellidoText;
    public javax.swing.JButton botonCargarDatos;
    private javax.swing.JButton botonVolverRegistrar;
    private javax.swing.JTextField celularText;
    public javax.swing.JTextField direccionText;
    public javax.swing.JTextField documentoText;
    private javax.swing.JTextField edadText;
    private com.toedter.calendar.JDateChooser fechaIngresoText;
    private com.toedter.calendar.JDateChooser fechaNacText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField nombreText;
    private javax.swing.JTextField observacionesText;
    private javax.swing.JTextField ocupacionText;
    private javax.swing.JPanel panelCargaDeDatos;
    private javax.swing.JTextField pesoText;
    // End of variables declaration//GEN-END:variables
}
