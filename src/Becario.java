import java.io.Serializable;

public class Becario implements Serializable {
    String nombre;
    String apellido;
    String sexo;
    int edad;
    int suspensos;
    String residencia;
    double ingresosAnuales;

    public Becario(String nombre, String apellido, String sexo, int edad, int suspensos, String residencia, double ingresosAnuales) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.suspensos = suspensos;
        this.residencia = residencia;
        this.ingresosAnuales = ingresosAnuales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSuspensos() {
        return suspensos;
    }

    public void setSuspensos(int suspensos) {
        this.suspensos = suspensos;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public double getIngresosAnuales() {
        return ingresosAnuales;
    }

    public void setIngresosAnuales(double ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }
}
