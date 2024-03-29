import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Persona implements Comparable<Persona> {
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona(Integer id, String nombre, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

public class StreamCollectorsToMapApp {
    public static void main(String[] args) {
        Persona persona1 = new Persona(111, "Juan", "Zamora", "Gandia");
        Persona persona2 = new Persona(222, "Ana", "Zurrieta", "Gandia");
        Persona persona3 = new Persona(333, "Ana", "Balbastre", "Xativa");
        List<Persona> lista = new ArrayList<Persona>(
                List.of(persona1, persona2, persona3));

        System.out.println("Mapa Personas de Gandia:");
        Map<Integer, Persona> mapaPersonasGandia = lista.stream().filter(p -> p.getDireccion().equals("Gandia"))
                .collect(Collectors.toMap(p -> p.getId(), p -> p));
        // values sobre un mapa devuelve una colección de Personas
        mapaPersonasGandia.values().stream().forEach(p -> System.out.println(p.toString()));
    }
}
