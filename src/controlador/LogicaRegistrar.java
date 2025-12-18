
package controlador;

import baseDeDatos.ClienteDao;
import java.awt.event.ActionEvent;
import modelo.Clientes;
import vista.JDialogRegistrar;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;

public class LogicaRegistrar implements ActionListener {
    
    private final Clientes modelo;
    private final JDialogRegistrar vistaR;
    
    public LogicaRegistrar(JDialogRegistrar vistaR, Clientes modelo){
        
        this.modelo = modelo;
        this.vistaR = vistaR;
        
        vistaR.fechaNacText().addPropertyChangeListener("date",evt->{
            if(vistaR.fechaNacText().getDate()!=null){
                int edad = calcularEdad(vistaR.fechaNacText().getDate());
                modelo.setEdad(edad);
                vistaR.edadText().setText(String.valueOf(edad));
            }
            
        });
        
        this.vistaR.getBotonVolverRegistrar().addActionListener(this);
        this.vistaR.getBotonCargarDatos().addActionListener(this);
        
    }
    
    private Boolean verificarNombre;
    private Boolean verificarDni;
    private Boolean verificarApellido;
    private Boolean verificarTelefono;
    private Boolean verificarPeso;
    private Boolean verificarAltura;
    private Boolean verificarOcupacion;
    private Boolean verificarDireccion;
    private Boolean verificarFechaIngreso;
    private Boolean verificarFechaNac;
    private Boolean verificarActividad;
    private Boolean verificarObservaciones;
    
    private int calcularEdad(Date fechaNacimiento){
        LocalDate nacimiento= fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento,hoy).getYears();
    }
    
    private void cargarDatos(){
        
        
        verificarDni = true ;
        verificarNombre = true ;
        verificarApellido = true ; 
        verificarTelefono = true ;
        verificarPeso = true ;
        verificarAltura = true ; 
        verificarOcupacion = true ;
        verificarDireccion = true ;
        verificarFechaIngreso = true;
        verificarFechaNac = true;
        verificarActividad = true;
        verificarObservaciones = true;
        
       //VERIFICAR NOMBRE
       
        String nombre = vistaR.nombreText().getText();
     
        if (nombre == null  || nombre.equals(" Nombre ") || nombre.trim().isEmpty() || !nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$")){
        
            verificarNombre = false;
            JOptionPane.showMessageDialog(vistaR, "Nombre vacio o con numeros");
            
        }else{
            verificarNombre = true;
            modelo.setNombre(nombre);
            
        }
        
        //VERIFICAR ACTIVIDAD PREVIA
        
        String actividadPrev = vistaR.actividadPrevText().getText();
        
        if (actividadPrev == null || actividadPrev.equals(" Actividad Previa ") || !actividadPrev.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$") ){
            verificarActividad = false ;
            JOptionPane.showMessageDialog(vistaR, " Actividad Previa vacia o con numeros ");
        }else{
            verificarActividad = true;
            modelo.setActividadPrevia(actividadPrev);
        }
        
        //VERIFICAR OCUPACION   
        
        String ocupacion = vistaR.ocupacionText().getText();
        
        if (ocupacion == null || ocupacion.equals(" Ocupacion ") || ocupacion.trim().isEmpty() || !ocupacion.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$")){
        
            verificarOcupacion = false;
            JOptionPane.showMessageDialog(vistaR, " Ocupacion vacia o con numeros ");
            
        }else{
            
            verificarOcupacion = true;
            modelo.setOcupacion(ocupacion);
            
        }
        
        //VERIFICAR DIRECCION
        
        String direccion = vistaR.direcccionText().getText();
        
        if (direccion == null || direccion.equals(" Direccion ") || direccion.trim().isEmpty()){
            
            verificarDireccion = false ;
            JOptionPane.showMessageDialog(vistaR, " Direccion vacio o con numeros ");
            
        }else{
            verificarDireccion = true ; 
            modelo.setDireccion(direccion);
        }
        
        
        
        //VERIFICAR APELLIDO 
        
        String apellido = vistaR.apellidoText().getText();
        
        if ( apellido == null || apellido.equals(" Apellido ") || apellido.trim().isEmpty() || !apellido.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$") ){
            
            verificarApellido = false;
            JOptionPane.showMessageDialog(vistaR, " Apellido  vacio o con numeros ");
            
        }else {
            verificarApellido = true ;
            modelo.setApellido(apellido);
            
        }
       
        
        //VERIFICAR DOCUMENT0
        
        String dniInteger = vistaR.documentoText().getText();
        
        
        if (dniInteger == null || dniInteger.trim().isEmpty() || dniInteger.equals(" Documento ") ) {
            
            verificarDni = false;
            JOptionPane.showMessageDialog(vistaR, "Documento  vacio");
            
        }else{
            
            try {
                
                int dni = Integer.parseInt(dniInteger);

                if (dni < 1000000 || dni > 70000000) {
                    verificarDni = false;
                    JOptionPane.showMessageDialog(vistaR, " Error ");
                } else {
                    
                    verificarDni = true;
                    modelo.setDni(dni);
                    
                }

            } catch (NumberFormatException e) {
                    verificarDni = false;
                    JOptionPane.showMessageDialog(vistaR, "Solo numeros en el documento (sin puntos) ");
            }
            
        }
            
        
        // VERIFICAR TELEFONO
        
        String telefonoInteger = vistaR.celularText().getText();

        if (telefonoInteger == null || telefonoInteger.trim().isEmpty() || telefonoInteger.equalsIgnoreCase(" Numero de Telefono ")) {
            
            verificarTelefono = false;
            JOptionPane.showMessageDialog(vistaR, "Telefono campo vacío");
            
        }else if (!telefonoInteger.matches("\\d{10}")){
            
            verificarTelefono = false;
            JOptionPane.showMessageDialog(vistaR," Solo 10 numeros ");
            
            
        }else{
            try {
                
                Long telefono = Long.parseLong(telefonoInteger);
                
                verificarTelefono = true;
                modelo.setNumeroCelular(telefono);
                    
                } catch (NumberFormatException e) {
                
                    verificarTelefono = false;
                    JOptionPane.showMessageDialog(vistaR, "Solo números (sin puntos ni letras)");
                    
                }
            } 
        
        // VERIFICAR PESO 
        
        String pesoInteger = vistaR.pesoText().getText();

        if (pesoInteger == null || pesoInteger.trim().isEmpty() || pesoInteger.equals(" Peso ")){
            
            verificarPeso = false;
            JOptionPane.showMessageDialog(vistaR, "Peso vacio ");
            
        }else{
            
            try{
                
                pesoInteger = pesoInteger.replace(',', '.');
                
                if (pesoInteger.equals(".") ) {
                    throw new NumberFormatException();
                }
                
                float peso = Float.parseFloat(pesoInteger);
                
                
                
                if ( peso <= 0 || peso >= 500 ){
                    
                    verificarPeso = false; 
                    JOptionPane.showMessageDialog(vistaR, " Error al ingresar peso (1 a 499) ");
               
                }else {
                    verificarPeso = true;
                    modelo.setPeso(peso);
                }
                
            }catch(NumberFormatException e ){
                
                verificarPeso= false;
                JOptionPane.showMessageDialog(vistaR, " No se puede numeros en el Peso ");
            
            }  
        }
        
        //VERIFICAR ALTURA
        
        String alturaInteger = vistaR.alturaText().getText();
        
        if (alturaInteger == null || alturaInteger.trim().isEmpty() || alturaInteger.equals(" Altura ")){
            
            verificarPeso = false;
            JOptionPane.showMessageDialog(vistaR, " Altura vacio ");
            
        }else {
            
            try{
                
                alturaInteger = alturaInteger.replace(',', '.');
                
                if (alturaInteger.equals(".") ) {
                    throw new NumberFormatException();
                }
                
                float altura = Float.parseFloat(alturaInteger);
                
                if ( altura <= 1 || altura >= 3){
                    
                    verificarAltura= false;
                    JOptionPane.showMessageDialog(vistaR, "Ingresar altura entre 1 a 3 metros");
                    
                }else{
                    
                    verificarAltura = true; 
                    modelo.setAltura(altura);
                    
                }
                
            }catch(NumberFormatException e ){
               
                verificarAltura= false;
                JOptionPane.showMessageDialog(vistaR, "No se pueden ingresar numeros ");
            
            }
 
        }
        
        //VERIFICAR FECHA NACIMIENTO
        
        Date fechaNAC = vistaR.fechaNacText().getDate();
        
        if( fechaNAC == null  ){
            verificarFechaNac = false;
            JOptionPane.showMessageDialog(vistaR, " Debe seleccionar una fecha ");
        }else{
            LocalDate fechaNacimiento = fechaNAC.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
            LocalDate hoy = LocalDate.now();

            long edad = ChronoUnit.YEARS.between(fechaNacimiento, hoy);

            if (fechaNacimiento.isAfter(hoy)) {
                verificarFechaNac = false;
                JOptionPane.showMessageDialog(vistaR, "La fecha de nacimiento no puede ser futura.");
            } else if (edad< 0 || edad > 100) {
                verificarFechaNac = false;
                JOptionPane.showMessageDialog(vistaR, "La edad no puede ser mayor a 100 años.");
            } else {
                verificarFechaNac = true;
                modelo.setFechaNac(fechaNAC);
            }
        }
        
        //VERIFICAR INGRESO
        Date fechaING = vistaR.fechaIngresoText().getDate();
        
        if( fechaING == null ){
            verificarFechaIngreso = false;
            JOptionPane.showMessageDialog(vistaR, " Debe seleccionar una fecha ");
        }else{
            verificarFechaNac = true;
            modelo.setFechaIngreso(fechaING);
        }
        
        String observaciones1 = vistaR.observacionesText().getText();
        
        if (observaciones1 == null  || nombre.equals(" Observaciones ") || observaciones1.trim().isEmpty() ){
        
            verificarObservaciones = false;
            JOptionPane.showMessageDialog(vistaR, "Observaciones vacio ");
            
        }else{
            verificarObservaciones = true;
            modelo.setObservaciones(observaciones1);
            
        }
        
        
    }
    
    
   
    
    public void mostrar(){
        
        System.out.println("---------------------------------------------");
        System.out.println(modelo.getNombre());
        System.out.println(modelo.getApellido());
        System.out.println(modelo.getEdad());
        System.out.println(modelo.getObservaciones());
        System.out.println(modelo.getNumeroCelular());
        System.out.println(modelo.getPeso());
        System.out.println(modelo.getAltura());
        System.out.println(modelo.getOcupacion());
        System.out.println(modelo.getActividadPrevia());
        System.out.println(modelo.getDireccion());
        System.out.println(modelo.getFechaNac());
        System.out.println(modelo.getFechaIngreso());
        
    }
    
    public void mensajeDeExito(){
        
        JOptionPane.showMessageDialog(vistaR, " CARGA EXITOSA!!! ");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object source = ae.getSource();
        ClienteDao cliente = new ClienteDao();
         
        if ( source == vistaR.getBotonVolverRegistrar()){
            vistaR.dispose();
        }
        
        if (source == vistaR.getBotonCargarDatos()) {
            
            cargarDatos();
            
            if(verificarDni == true && verificarNombre == true && verificarApellido == true && 
               verificarTelefono == true &&  verificarPeso == true && 
               verificarAltura == true && verificarDireccion == true && verificarOcupacion == true && 
               verificarFechaIngreso == true && verificarFechaNac == true && verificarActividad == true ){ 
                
                
                boolean exito = cliente.insertarCliente(modelo);
                
                
                if(exito){
                    
                    mostrar(); 
                    mensajeDeExito();
                    vistaR.limpiarCampos();
                    
                }else{
                    JOptionPane.showMessageDialog(vistaR, " ERROR EN GUARDAR EN LA BASE DE DATOS ");
                }
            }
        }
        
    }
    
    
}
