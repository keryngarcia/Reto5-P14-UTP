package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.MaterialProyectoDAO;
import model.dao.LideresSalarioCartagoDAO;
import model.dao.LideresCostosPromDAO;
import model.vo.MaterialProyectoVO;
import model.vo.LiderSalarioCartagoVO;
import model.vo.LiderCostoPromVO;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientos {
    
    private static final MaterialProyectoDAO materialProyectoDao = new MaterialProyectoDAO();
    private static final LideresSalarioCartagoDAO lideresSalarioCartagoDao = new LideresSalarioCartagoDAO();
    private static final LideresCostosPromDAO lideresCostosPromDao = new LideresCostosPromDAO();

    public ControladorRequerimientos(){
       // materialProyectoDao= new MaterialProyectoDao();
    }
    public static ArrayList<MaterialProyectoVO> consultarMaterialesProyecto() throws SQLException{
        return materialProyectoDao.MaterialesProyecto();
    }

    public static ArrayList<LiderSalarioCartagoVO> consultarLideresCartago() throws SQLException{
        return lideresSalarioCartagoDao.ConsultarLideresCartago();
    }

    public static ArrayList<LiderCostoPromVO> consultarLideresCostoProm() throws SQLException{
        return lideresCostosPromDao.ConsultarLideresCostoProm();
    }

    
}
