
package baseDeDatos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Clientes;
import modelo.Pago;


public class PagoDao {
    
    //Enviar los datos de pagos 
    private Pago pago;
    private Clientes cliente;
            
    private final Conexion conexionBD = new Conexion();
    
    
    public Boolean registrarPago(Pago pago){
        
        if (conexionBD == null) {
            
            System.out.println(" No hay conexión a la base de datos. Pago no insertado.");
        
        }
       
        String sql = "INSERT INTO pagos (idCliente, idPlan, metodoPago, observaciones, monto, fechaPago, fechaVencimiento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = conexionBD.getConexion(); 
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, pago.getIdCliente());
            ps.setInt(2, pago.getIdPlan());
            ps.setString(3, pago.getMetodoPago());
            ps.setString(4, pago.getObservaciones());
            ps.setDouble(5, pago.getMonto());
            ps.setDate(6, new java.sql.Date(pago.getFechaPago().getTime()));
            ps.setDate(7, new java.sql.Date(pago.getFechaVencimiento().getTime()));

            
            ps.executeUpdate();
            ps.close();
            
            return true;
            
        }catch (SQLException e){
            
            System.out.println(" Error al insertar cliente: " + e.getMessage());
            return false;
            
        }  
    }    
    
    
    
    
    
    public Clientes buscarClientePorDni(int dni) {
        
        Clientes buscar = null;
        String sql = "SELECT idCliente, nombre, apellido FROM cliente WHERE dni = ?";
        
        try (Connection conn = conexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                buscar = new Clientes();
                buscar.setIdCliente(rs.getInt("idCliente"));
                buscar.setNombre(rs.getString("nombre"));
                buscar.setApellido(rs.getString("apellido"));
                
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por DNI: " + e.getMessage());
        }
        
        return buscar;
    }
    
    public List<Pago> listarPagos() {
        
        List<Pago> lista = new ArrayList<>();
        
        String sql = "SELECT  c.apellido, c.nombre, pl.nombrePlan, p.monto, p.fechaPago, p.fechaVencimiento, p.metodoPago, p.observaciones " +
                    "FROM pagos p " +
                    "JOIN cliente c ON p.idCliente = c.idCliente " +
                    "JOIN plan pl ON p.idPlan = pl.idPlan "+
                    "JOIN ( "+
                    "    SELECT idCliente, MAX(fechaPago) AS ultimaFechaPago "+
                    "    FROM pagos "+
                    "    GROUP BY idCliente "+
                    ") ult ON p.idCliente = ult.idCliente AND p.fechaPago = ult.ultimaFechaPago " +
                    "AND p.fechaVencimiento < CURDATE() "+
                    "ORDER BY p.fechaVencimiento DESC ";
        
         //System.out.println("SQL listarPagos: " + sql);
    
        try(Connection conn = Conexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Pago mostrar = new Pago();
                
                mostrar.setApellidoCliente(rs.getString("apellido"));
                mostrar.setNombreCliente(rs.getString("nombre"));
                mostrar.setNombrePlan(rs.getString("nombrePlan"));
                mostrar.setMonto(rs.getFloat("monto"));
                mostrar.setFechaPago(rs.getDate("fechaPago"));
                mostrar.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                //mostrar.setMetodoPago(rs.getString("metodoPago"));
                mostrar.setObservaciones(rs.getString("observaciones"));
                lista.add(mostrar);
   
            }
            
        }catch (SQLException e ){
            
            System.out.println(" Error en pago vencidos: "+ e.getMessage());
            
        }
        
        return lista;
    }
    
    public Pago obtenerUltimoPago(int dni){
        
        Pago resultado = null;
        
        String sqlCliente = "SELECT idCliente, nombre, apellido FROM  cliente WHERE dni = ? ";
        
        try(Connection conn = Conexion.getConexion();
            PreparedStatement psCli = conn.prepareStatement(sqlCliente)){
            
            psCli.setInt(1, dni);
            ResultSet rsCli = psCli.executeQuery();
            
            if(!rsCli.next()){
                return null; //No hay Cliente
            }
            
            int idCliente = rsCli.getInt("idCliente");
            String nombre = rsCli.getString("nombre");
            String apellido = rsCli.getString("apellido");
            
            String sqlPago = "SELECT p.monto, p.fechaPago, p.fechaVencimiento, pl.nombrePlan "+
                            "FROM pagos p "+
                            "JOIN plan pl ON p.idPlan = pl.idPlan "+
                            "WHERE p.idCliente = ? "+
                            "ORDER BY p.fechaPago DESC "+
                            "LIMIT 1 ";
                             
            
            PreparedStatement psPago = conn.prepareStatement(sqlPago);
            psPago.setInt(1, idCliente);
            ResultSet rsPago = psPago.executeQuery();
            
            if(rsPago.next()){
                resultado = new Pago();
                
                resultado.setIdCliente(idCliente);
                resultado.setNombreCliente(nombre);
                resultado.setApellidoCliente(apellido);
                
                resultado.setMonto(rsPago.getFloat("monto"));
                resultado.setFechaPago(rsPago.getDate("fechaPago"));
                resultado.setFechaVencimiento(rsPago.getDate("fechaVencimiento"));
                resultado.setNombrePlan(rsPago.getString("nombrePlan"));
            }
            
            rsPago.close();
            psPago.close();
            
        }catch(SQLException e){
            System.out.println("Error "+ e.getMessage());
        }
        
        
        return resultado;
    }

    
}
