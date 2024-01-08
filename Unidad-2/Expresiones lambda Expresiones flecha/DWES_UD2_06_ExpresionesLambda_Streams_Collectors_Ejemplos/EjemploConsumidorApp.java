import java.util.function.Consumer;

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

@FunctionalInterface
interface IFuncionalSaludo {
    public void imprime(String nom);
}

@FunctionalInterface
interface IFuncionalSaludoCompleto {
    public void imprime(String nom, String apel);
}

public class EjemploConsumidorApp {
    public static void main(String[] args) {
        // Ejemplos expresiones Lambda consumidoras con Interfaces funcionales
        IFuncionalSaludo saludo = (nombre) -> System.out.println("Hola " 
                                                + nombre);
        saludo.imprime("Jose");
        IFuncionalSaludoCompleto saludoCompleto = (nombre, apellido) -> System.out
                .println("Hola " + nombre + " " + apellido);
        saludoCompleto.imprime("Jose Ramón", "Cebolla");
 
        // Ejemplo expresiones Lambda con Interfaz Consumer<T>
        Consumer<String> saludoConConsumer = (nombre) -> System.out.println("Hola " 
                                                + nombre);
        saludoConConsumer.accept("Jose");
        Consumer<Persona> persona = (p) -> System.out.println("Hola, "+ p.getNombre());
        persona.accept(new Persona("Jose Ramón ", "Cebolla", "Rotova"));
    }
}
