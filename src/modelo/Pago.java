
package modelo;

import java.util.Date;


public class Pago {
    
    
    private int idCliente, idPlan;
    private String metodoPago, observaciones,nombreCliente , apellidoCliente, nombrePlan;
    private double monto;
    private Date fechaPago, fechaVencimiento;
    
    public void setNombreCliente(String nombreCliente ){ this.nombreCliente = nombreCliente; }
    
    public void setApellidoCliente(String apellidoCliente){ this.apellidoCliente = apellidoCliente; }
    
    public void setNombrePlan(String nombrePlan){ this.nombrePlan = nombrePlan;}
    public void setIdCliente(int idCliente) { this.idCliente = idCliente;}
    
    public void setObservaciones(String observaciones ) { this.observaciones = observaciones;}

    public void setIdPlan(int idPlan){ this.idPlan = idPlan; }

    public void setMonto(double monto) { this.monto = monto; }

    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    //----------------------------------------------------------------------------------------------------//

    public String getNombreCliente(){ return nombreCliente; }
    
    public String getApellidoCliente(){ return apellidoCliente; }
    
    public String getNombrePlan(){ return nombrePlan;}
    
    public int getIdCliente() { return idCliente; }
    
    public String getObservaciones(){ return observaciones;}

    public int getIdPlan() { return idPlan; }

    public double getMonto() { return monto; }

    public Date getFechaPago() { return fechaPago; }

    public Date getFechaVencimiento() { return fechaVencimiento; }

    public String getMetodoPago() { return metodoPago; }
    
    
    
}
