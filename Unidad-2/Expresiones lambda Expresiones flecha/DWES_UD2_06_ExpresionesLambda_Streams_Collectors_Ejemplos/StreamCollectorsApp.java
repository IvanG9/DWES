import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
    }

    public int compareTo(Persona persona) {
        return nombre.compareTo(persona.getNombre());
    }
}

public class StreamCollectorsApp {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Zamora","Gandia");
        Persona persona2 = new Persona("Ana", "Zurrieta","Gandia");
        Persona persona3 = new Persona("Ana", "Balbastre","Xativa");
        List<Persona> lista= new ArrayList<Persona>(
            List.of(persona1,persona2,persona3));

        System.out.println("Personas de Gandia:");
        List<Persona> listaPersonasGandia=lista.stream().
        filter(p->p.getDireccion().equals("Gandia")).
        collect(Collectors.toList());
        listaPersonasGandia.stream().forEach(p->System.out.println(p));

        System.out.println("Poblaciones de las personas:");
        Set<String> listaPoblaciones= lista.stream().
        map(p->p.getDireccion()).collect(Collectors.toSet());
        listaPoblaciones.forEach(System.out::println);
    }
}
