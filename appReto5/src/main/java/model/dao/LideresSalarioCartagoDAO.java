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
import model.vo.LiderSalarioCartagoVO;

public class LideresSalarioCartagoDAO {

    public ArrayList<LiderSalarioCartagoVO> ConsultarLideresCartago() throws SQLException{
        // Crear arreglo para guardar registro del resultado de la consulta.
        // que se ejecuta.

        ArrayList<LiderSalarioCartagoVO> respuestaconsulta1 = new ArrayList<LiderSalarioCartagoVO>();

        ///Abrir la conexión con la base de datos 

        Connection conexion = JDBCutilities.getConnection();
        // Ejecitar la consulta 
        String consulta = "SELECT Nombre || ' ' || Primer_Apellido || ' ' || Segundo_Apellido AS Nombre , round(Salario,2) Salario "
                          +"FROM Lider "
                          +"WHERE Ciudad_Residencia LIKE '%Cartago%' ORDER BY Nombre; ";
        //System.out.println(consulta);
        //ejecutar consulta statement

        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(consulta);

        // recorrer resultset 
        while(rs.next()){
            String Nombre = rs.getString("Nombre");
            Integer Salario = rs.getInt("Salario");
            
            respuestaconsulta1.add(new LiderSalarioCartagoVO(Nombre,Salario));
        }

        // Cerrar la conexión 
        conexion.close();
        return respuestaconsulta1;
    }
    
}
