package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCutilities;

//Encapsulamiento de los datos
import model.vo.LiderCostoPromVO;

public class LideresCostosPromDAO {
    public ArrayList<LiderCostoPromVO> ConsultarLideresCostoProm() throws SQLException{
        // Crear arreglo para guardar registro del resultado de la consulta.
        // que se ejecuta.
        ArrayList<LiderCostoPromVO> respuestaconsulta5 = new ArrayList<LiderCostoPromVO>();
        ///Abrir la conexión con la base de datos 
        Connection conexion = JDBCutilities.getConnection();
        // Ejecitar la consulta 
        String consulta = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS Nombre, "
                            + " SUM(mc.Precio_Unidad * c.Cantidad)/ COUNT(DISTINCT p.ID_Proyecto) Promedio" 
                            + " FROM Lider l " 
                            + " LEFT JOIN Proyecto p ON l.ID_Lider = p.ID_Lider " 
                            + " LEFT JOIN Compra c on p.ID_Proyecto = c.ID_Proyecto " 
                            + " LEFT JOIN MaterialConstruccion mc on c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion" 
                            + " WHERE p.Clasificacion = 'Condominio'" 
                            + " GROUP BY l.ID_Lider " 
                            + " HAVING COUNT(DISTINCT p.ID_Proyecto) >= 2 " 
                            + " ORDER BY Promedio DESC" 
                            + " LIMIT 3";
        //System.out.println(consulta);
        //ejecutar consulta statement
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        // recorrer resultset 
       
        while(rs.next()){
            String Nombre = rs.getString("Nombre");
            Integer Promedio = rs.getInt("Promedio");
            respuestaconsulta5.add(new LiderCostoPromVO(Nombre,Promedio));
        }

        // Cerrar la conexión 
        conexion.close();
        return respuestaconsulta5;
    }
}

