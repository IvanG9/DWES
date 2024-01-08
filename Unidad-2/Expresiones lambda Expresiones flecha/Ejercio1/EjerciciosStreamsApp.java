import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Filter;
import java.util.ArrayList;
import java.util.Comparator;
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

public class EjerciciosStreamsApp {
    public static void main(String[] args) {
        Persona persona1 = new Persona(111, "Juan", "Zamora", "Onteniente");
        Persona persona2 = new Persona(222, "Ana", "Zurrieta", "Gandia");
        Persona persona3 = new Persona(333, "Ana", "Balbastre", "Xativa");
        Persona persona4 = new Persona(333, "Pedro", "Gimenez", "Gandia");
        List<Persona> lista = new ArrayList<Persona>(
                List.of(persona1, persona2, persona3, persona4));

        System.out.println("Lista de nombres no repetidos que contiene una 'A' ordenados:");
        //Uno

        Optional<String> poblacionA = lista.stream().map(p -> p.getNombre()).distinct().filter(p -> p.contains("a")).reduce((s1, s2) -> s1 + "," + s2);
        System.out.println(poblacionA);

        //Otro

        lista.stream().map(p -> p.getNombre()).distinct().filter(p -> p.contains("a")).sorted().forEach(System.out::println);

        // Deberá devolver:
        // Ana
        // Juan

        System.out.println("Lista de apellidos no repetidos ordenados inversamente en una sola linea:");

        Optional<String> apellidos = lista.stream().map(p -> p.getApellido()).distinct().sorted(Comparator.reverseOrder()).reduce((s1, s2) -> s1 + "," + s2);
        System.out.println(apellidos);

        // Deberá devolver:
        // Zurrieta,Zamora,Gimenez,Balbastre

        System.out.println("Nombre y apellidos de la primera persona de Gandia si lo ordenamos por apellidos:");

        Map<Integer, Persona> mapaPersonasGandia = lista.stream().filter(p->p.getDireccion().equals("Gandia")).collect(Collectors.toMap(p->p.getId(), p->p));
        Optional<Persona> primeraPersona = mapaPersonasGandia.values().stream().findFirst();
        System.out.println(primeraPersona.get().getNombre()+" "+primeraPersona.get().getApellido());

        // Deberá devolver:
        // Pedro Gimenez

    }
}
