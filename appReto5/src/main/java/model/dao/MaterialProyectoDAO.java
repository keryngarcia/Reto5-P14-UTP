package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCutilities;

//Encapsulamiento de los datos
import model.vo.MaterialProyectoVO;

public class MaterialProyectoDAO {
    
    public ArrayList<MaterialProyectoVO> MaterialesProyecto() throws SQLException{
        // Crear arreglo para guardar registro del resultado de la consulta.
        // que se ejecuta.
        ArrayList<MaterialProyectoVO> respuestaconsulta4 = new ArrayList<MaterialProyectoVO>();
        ///Abrir la conexión con la base de datos 
        Connection conexion = JDBCutilities.getConnection();
        // Ejecitar la consulta 
        String consulta = "SELECT mc.Nombre_Material as Nombre_Material , mc.Precio_Unidad as Precio_Unidad , SUM(c.Cantidad) as Total "
                            +"FROM Proyecto p "
                            +"LEFT JOIN Compra c on p.ID_Proyecto = c.ID_Proyecto "
                            +"LEFT JOIN MaterialConstruccion mc on c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion "
                            +"WHERE p.ID_Proyecto  IN (199,7,378,120,216) "
                            +"GROUP BY mc.Nombre_Material "
                            +"ORDER BY mc.Nombre_Material ;";
        //System.out.println(consulta);
        //ejecutar consulta statement
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        // recorrer resultset 
        while(rs.next()){
            String Nombre_Material = rs.getString("Nombre_Material");
            Integer Precio_Unidad = rs.getInt("Precio_Unidad");
            Integer Total = rs.getInt("Total");
            respuestaconsulta4.add(new MaterialProyectoVO(Nombre_Material,Precio_Unidad,Total));
        }

        // Cerrar la conexión 
        conexion.close();
        return respuestaconsulta4;
    }
}
