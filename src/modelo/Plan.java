
package modelo;


public class Plan {
    private String nombrePlan;
    private Double monto;
    private int idPlan,dias;
    
    
    public void setNombrePlan(String nombrePlan){ this.nombrePlan = nombrePlan; }
    
    public void setMonto(double monto){ this.monto = monto; }
    
    public void setDias(int dias){ this.dias = dias;}
    
    public void setIdPlan(int idPlan){ this.idPlan = idPlan;}
    
    //----------------------------------------------------------------------------//
    
    public int getIdPlan(){ return idPlan;}
    
    public String getNombrePlan(){ return nombrePlan; } 
    
    public double getMonto(){ return monto; }
    
    public int getDias(){ return dias;}
    
}
