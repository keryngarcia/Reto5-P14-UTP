package model.vo;

public class MaterialProyectoVO {
    private String Nombre_Material;
    private Integer Precio_Unidad;
    private Integer Total;
    
    public MaterialProyectoVO(String Nombre_Material, Integer Precio_Unidad, Integer Total) {
        this.Nombre_Material = Nombre_Material;
        this.Precio_Unidad = Precio_Unidad;
        this.Total = Total;
    }

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }

    public Integer getPrecio_Unidad() {
        return Precio_Unidad;
    }

    public void setPrecio_Unidad(Integer precio_Unidad) {
        Precio_Unidad = precio_Unidad;
    }

    public Integer getTotal() {
        return Total;
    }
    
    public void setTotal(Integer total) {
        Total = total;
    }

}
