package model.vo;

public class LiderSalarioCartagoVO {
    private String Nombre;
    private Integer Salario;

    public LiderSalarioCartagoVO(String Nombre, Integer Salario){
        this.Nombre = Nombre;
        this.Salario = Salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getSalario() {
        return Salario;
    }

    public void setSalario(Integer salario) {
        Salario = salario;
    }
}