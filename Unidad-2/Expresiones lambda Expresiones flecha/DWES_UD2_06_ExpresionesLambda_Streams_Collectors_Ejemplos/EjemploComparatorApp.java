import java.util.Comparator;

class Persona {
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}


public class EjemploComparatorApp {
    public static void main(String[] args) {
        Comparator<Persona> comparaPersonas = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Persona p1 = new Persona("Ana", "Gonzalez","Xativa");
        Persona p2 = new Persona("Jose", "Martinez","Xativa");
        System.out.println("p1>p2= "+comparaPersonas.compare(p1, p2));// > 0
        System.out.println("p1<p2= "+comparaPersonas.reversed().compare(p1, p2));  // < 0
    }
}
