
package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gimnasio_bdd";
    private static final String USER= "root";
    private static final String PASSWORD = "";
    
    private static Connection conn = null;
    
    public static Connection getConexion() {
        try{
            if (conn == null || conn.isClosed()){
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println(" Conexion lograda!!! ");
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error en la conexion");
        }
        
        
        return conn;
    }
    
}