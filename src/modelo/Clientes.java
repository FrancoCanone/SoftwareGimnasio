package modelo;

import java.util.Date;

public class Clientes{
    
    private String nombre, apellido, ocupacion, actividadPrevia, direccion, observaciones;
    private int idCliente, edad, dni; 
    private Long numeroCelular; 
    private float peso, altura; 
    private Date fechaNac, fechaIngreso;
    
    public Clientes(){
        
    }
    
    //----------------------------------------------------------------------------------//
    
    public int getIdCliente(){return idCliente;}
    
    public String getNombre(){ return nombre; }
    
    public String getApellido(){ return apellido; }
    
    public String getObservaciones(){ return observaciones;}
    
    public String getDireccion(){ return direccion; }
    
    public String getOcupacion(){ return ocupacion; }
    
    public String getActividadPrevia(){ return actividadPrevia;}
    
    public int getEdad(){ return edad; }

    public int getDni(){ return dni; }
    
    public float getPeso(){ return peso; }
    
    public float getAltura(){ return altura; }
    
    public Long getNumeroCelular(){return numeroCelular;}
    
    public Date getFechaNac(){return fechaNac;}
    
    public Date getFechaIngreso(){return fechaIngreso;}
    
    //---------------------------------------------------------------------------------//
    
    public void setIdCliente(int idCliente){this.idCliente = idCliente;}
    
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setApellido(String apellido){ this.apellido = apellido; }
    
    public void setObservaciones(String observaciones){ this.observaciones = observaciones;}
    
    public void setDireccion(String direccion){ this.direccion = direccion;} 
    
    public void setOcupacion(String ocupacion){ this.ocupacion = ocupacion; }
    
    public void setActividadPrevia(String actividadPrevia){ this.actividadPrevia = actividadPrevia; }
    
    public void setEdad(int edad){ this.edad = edad; }
    
    public void setDni(int dni) { this.dni = dni; }
    
    public void setPeso(float peso){ this.peso = peso; }
    
    public void setAltura(float altura) { this.altura = altura; }
    
    public void setNumeroCelular(Long numeroCelular){ this.numeroCelular = numeroCelular; }
    
    public void setFechaNac(Date fechaNac ){ this.fechaNac = fechaNac; }
    
    public void setFechaIngreso(Date fechaIngreso ){ this.fechaIngreso = fechaIngreso; }
        
}
