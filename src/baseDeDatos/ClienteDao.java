
package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import modelo.Clientes;



public class ClienteDao{
    
    Conexion conexionBD = new Conexion();

    public Boolean insertarCliente(Clientes cliente){
        
        if (conexionBD == null) {
            
            System.out.println(" No hay conexión a la base de datos. Cliente no insertado.");
        
        }
       
        String sql = "INSERT INTO cliente (nombre, apellido, dni, observaciones, numeroCelular, peso, altura, direccion, ocupacion, actividadPrevia, fechaNac, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        
        try (Connection conn = conexionBD.getConexion(); 
                PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setString(4,cliente.getObservaciones());
            ps.setLong(5, cliente.getNumeroCelular());
            ps.setFloat(6, cliente.getPeso());
            ps.setFloat(7, cliente.getAltura());
            ps.setString(8, cliente.getDireccion());
            ps.setString(9, cliente.getOcupacion());
            ps.setString(10, cliente.getActividadPrevia());
            ps.setDate(11, new java.sql.Date(cliente.getFechaNac().getTime()));
            ps.setDate(12, new java.sql.Date(cliente.getFechaIngreso().getTime()));
            
            ps.executeUpdate();
            ps.close();
            
            return true;
            
        }catch (SQLException e){
            
            System.out.println(" Error al insertar cliente: " + e.getMessage());
            return false;
            
        }  
    }
    
    
    public boolean actualizarCliente(int idCliente, String nombre, String apellido, int dni, long numeroCelular, float peso, float altura, String direccion, String observaciones, String ocupacion, String actividadPrevia, java.sql.Date fechaNac, java.sql.Date fechaIngreso){
        
        String sql = "UPDATE cliente SET nombre=?, apellido=?, dni=?, numeroCelular=?, peso=?, altura=?, direccion=?, observaciones=?, ocupacion=?, actividadPrevia=?, fechaNac=?, fechaIngreso=? WHERE idCliente=?";
        
        try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1,nombre);
            ps.setString(2,apellido);
            ps.setInt(3, dni);
            ps.setLong(4, numeroCelular);
            ps.setFloat(5,peso);
            ps.setFloat(6,altura);
            ps.setString(7,direccion);
            ps.setString(8, observaciones);
            ps.setString(9,ocupacion);
            ps.setString(10,actividadPrevia);
            ps.setDate(11, fechaNac);
            ps.setDate(12, fechaIngreso);
            ps.setInt(13, idCliente);
            
            ps.executeUpdate();
            return true;
            
        }catch(SQLException e){
            
            System.out.println("Error "+e.getMessage());
            return false;
            
        }
    
    
    }
 
}
