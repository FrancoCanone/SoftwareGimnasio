
package baseDeDatos;



import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Plan;
        
        
        
public class PlanDao {
    
    private Plan plan;
    
    public void insertarPlan(Plan plan) {
        
        String sql = "INSERT INTO plan (nombrePlan, precio, duracion) VALUES (?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, plan.getNombrePlan());
            ps.setDouble(2, plan.getMonto());
            ps.setInt(3, plan.getDias());

            ps.executeUpdate();
            System.out.println("Plan insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar plan: " + e.getMessage());
        }
    }
    
    
    public List<Plan> listarMembresias(){
        
        List<Plan> listaM = new ArrayList<>();
        
        String sql = "SELECT idPlan, nombrePlan, precio, duracion From plan";
        
        try(Connection conn = Conexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                Plan mostrar = new Plan();
                
                mostrar.setIdPlan(rs.getInt("idPlan"));
                mostrar.setNombrePlan(rs.getString("nombrePlan"));
                mostrar.setMonto(rs.getDouble("precio"));
                mostrar.setDias(rs.getInt("duracion"));
                listaM.add(mostrar);
            }
            
            
            
        }catch(SQLException e){
                
            System.out.println("error en cargar membresias "+ e.getMessage());
        }
        
        
        return listaM;
    }
    
    public boolean actualizarPlan( int idPlan ,String nombrePlan, Double precio, int duracion  ){
        
        String sql = "UPDATE plan SET nombrePlan=?, precio=?, duracion=? WHERE idPlan=? ";
        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombrePlan);
            ps.setDouble(2, precio);
            ps.setInt(3,duracion);
            ps.setInt(4,idPlan);
            
            ps.executeUpdate();
            return true;
            
        }catch (SQLException e ){
            
            System.out.println("Error "+ e.getMessage());
            return false;
            
        }
        
        
        
    }
    
    
    
    public ArrayList<String> obtenerPlanes() {
        
        ArrayList<String> planes = new ArrayList<>();
        String sql = "SELECT nombrePlan FROM plan";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                planes.add(rs.getString("nombrePlan"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener planes: " + e.getMessage());
        }
        
        return planes;
    }

    public double obtenerPrecioPorNombre(String nombrePlan) {
        
        double precio = 0.0;
        String sql = "SELECT precio FROM plan WHERE nombrePlan = ?";
        
        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombrePlan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener precio: " + e.getMessage());
        }
        
        return precio;
    }
    
    public int obtenerIdPorPlan(String nombrePlan) {
        
        int idPlan = -1;
        
        
        String sql = "SELECT idPlan, duracion FROM plan WHERE nombrePlan = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombrePlan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idPlan = rs.getInt("idPlan");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener duracion y id del plan: " + e.getMessage());
        }
    
        return idPlan;
    }
    
    public int obtenerDuracion(String nombrePlan) {
        
        int duracion = 30;
        
        String sql = "SELECT duracion FROM plan WHERE nombrePlan = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombrePlan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                duracion = rs.getInt("duracion");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener duracion del plan: " + e.getMessage());
        }
    
        return duracion;
    }
    
    public void eliminarPlan(int idPlan) {
        
        String sql = "DELETE FROM plan WHERE idPlan = ?";
        
        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idPlan);
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Plan eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún plan con el ID especificado.");
            }
  
        } catch (SQLException e) {
            System.out.println("Error al eliminar el plan: " + e.getMessage());
        }
   
    }
    

}
