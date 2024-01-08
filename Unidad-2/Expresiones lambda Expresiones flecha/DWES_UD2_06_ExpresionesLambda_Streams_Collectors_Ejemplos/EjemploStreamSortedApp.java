import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class ComparaDireccion implements Comparator<Persona> {
    public int compare(Persona p1, Persona p2) {
        return p1.getDireccion().compareTo(p2.getDireccion());
    }
}

class Persona implements Comparable<Persona> {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre +", apellido=" + apellido + ", direccion=" + direccion + "]";
    }
	
    public int compareTo(Persona persona) {
        return nombre.compareTo(persona.getNombre());
	}
}

public class EjemploStreamSortedApp {
    public static void main(String[] args) {
        Comparator<Persona> comparaNombreApellidos = (p1, p2) -> 
        {int compara = p1.getNombre().compareTo(p2.getNombre());
            if (compara != 0)
                return compara;
            else
                return p1.getApellido().compareTo(p2.getApellido());
        };
        Persona persona1 = new Persona("Juan", "Zamora","Gandia");
        Persona persona2 = new Persona("Ana", "Zurrieta","Gandia");
        Persona persona3 = new Persona("Ana", "Balbastre","Xativa");
        List<Persona> lista= new ArrayList<Persona>(
            List.of(persona1,persona2,persona3));
        System.out.println("ORDEN por defecto (Comparable por nombre):");
        lista.stream().sorted().forEach(System.out::println);
        System.out.println("ORDEN ComparaDireccion:");
        lista.stream().sorted(new ComparaDireccion()).forEach(System.out::println);
        System.out.println("ORDEN comparaNombreApellidos:");
        lista.stream().sorted(comparaNombreApellidos).forEach(System.out::println);
        System.out.println("La lista realmente no ha cambiado:");
        lista.forEach(System.out::println);
    }
}
