import java.io.Serializable;

public class MiClase implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private int edad;
    private int cedula;


    public MiClase(String nombre, int edad, int cedula){
        this.nombre=nombre;
        this.edad=edad;
        this.cedula=cedula;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString(){
        return "Nombre:"+nombre+"\nEdad:"+edad+"\nCedula: "+cedula;

    }
}